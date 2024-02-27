package com.cs4520.assignment3

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.cs4520.assignment3.R
import com.cs4520.assignment3.databinding.FragmentMvpBinding

class MVPFragment : Fragment(), MVPContract.Contract.View {

    private var _binding: FragmentMvpBinding? = null
    private val binding get() = _binding!!

    // creating object of Presenter interface in Contract
    private var presenter: MVPPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_mvp, container, false)
        // instantiating object of Presenter Interface
        _binding = FragmentMvpBinding.inflate(inflater, container, false)
        val view = binding.root
        presenter = MVPPresenter(_binding!!, MVPModel())
        val addButton = binding.addButtonMvp
        val subButton = binding.subButtonMvp
        val multButton = binding.multButtonMvp
        val divButton = binding.divButtonMvp
        var res: Double? = null

            addButton.setOnClickListener {
                if (binding.num1Mvp.text.toString() != "" && binding.num2Mvp.text.toString() != "") {
                    res = presenter!!.onAddButtonClick(
                        binding.num1Mvp.text.toString().toDouble(),
                        binding.num2Mvp.text.toString().toDouble()
                    )
                    Toast.makeText(requireActivity(), "Successful operation.", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(requireActivity(), "Invalid operation.", Toast.LENGTH_SHORT).show()
                }
            }

            subButton.setOnClickListener {
                if (binding.num1Mvp.text.toString() != "" && binding.num2Mvp.text.toString() != "") {
                    res = presenter!!.onSubtractButtonClick(
                        binding.num1Mvp.text.toString().toDouble(),
                        binding.num2Mvp.text.toString().toDouble()
                    )
                    Toast.makeText(requireActivity(), "Successful operation.", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(requireActivity(), "Invalid operation.", Toast.LENGTH_SHORT).show()
                }
            }

            multButton.setOnClickListener {
                if (binding.num1Mvp.text.toString() != "" && binding.num2Mvp.text.toString() != "") {
                    res = presenter!!.onMultiplyButtonClick(
                        binding.num1Mvp.text.toString().toDouble(),
                        binding.num2Mvp.text.toString().toDouble()
                    )
                    if (res == null) {
                        Toast.makeText(requireActivity(), "Invalid operation.", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(requireActivity(), "Successful operation.", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(requireActivity(), "Invalid operation.", Toast.LENGTH_SHORT).show()
                }
            }

            divButton.setOnClickListener {
                if (binding.num1Mvp.text.toString() != "" && binding.num2Mvp.text.toString() != "") {
                    res = presenter!!.onDivideButtonClick(
                        binding.num1Mvp.text.toString().toDouble(),
                        binding.num2Mvp.text.toString().toDouble()
                    )
                    Toast.makeText(requireActivity(), "Successful operation.", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(requireActivity(), "Invalid operation.", Toast.LENGTH_SHORT).show()
                }
            }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}