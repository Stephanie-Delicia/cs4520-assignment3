package com.cs4520.assignment3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val navHostFragmentController = requireActivity().supportFragmentManager
            .findFragmentById(R.id.navFragment)?.findNavController()
        val mvpBtn = view.findViewById<Button>(R.id.mvp_button)
        val mvvmBtn = view.findViewById<Button>(R.id.mvvm_button)
        mvpBtn.setOnClickListener{
            navHostFragmentController?.navigate(R.id.action_homeFragment_to_MVPFragment)
        }

        mvvmBtn.setOnClickListener{
            navHostFragmentController?.navigate(R.id.action_homeFragment_to_MVVMFragment)
        }
        // Inflate the layout for this fragment
        return view
    }

}