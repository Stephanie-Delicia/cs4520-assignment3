package com.cs4520.assignment3.MVVM

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import com.cs4520.assignment3.R
import androidx.databinding.DataBindingUtil;
import com.cs4520.assignment3.databinding.FragmentMvvmBinding


class MVVMFragment : Fragment() {
    private lateinit var mvvmBinding : FragmentMvvmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //var view = inflater.inflate(R.layout.fragment_mvvm, container, false)
        mvvmBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_mvvm,
            container, false)
        val view = mvvmBinding.root
        return view
    }

    // any change in toastMessage attribute
    // defined on the Button with bind prefix
    // invokes this method
    @BindingAdapter("toastMessage")
    fun runMe(view: View, message: String?) {
        if (message != null) Toast
            .makeText(
                view.context, message,
                Toast.LENGTH_SHORT
            )
            .show()
    }
}