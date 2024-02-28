package com.cs4520.assignment3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
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
        var res: Double?

        if (savedInstanceState != null)
        {
            val result = savedInstanceState.getString("result", "")
            binding.resultMvp.text = result
        }

        addButton.setOnClickListener {
            if (binding.num1Mvp.text.toString() != "" && binding.num2Mvp.text.toString() != "") {
                res = presenter!!.onAddButtonClick(
                    binding.num1Mvp.text.toString().toDouble(),
                    binding.num2Mvp.text.toString().toDouble()
                )
                Toast.makeText(requireActivity(), "Successful operation.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireActivity(), "Invalid operation.", Toast.LENGTH_SHORT).show()
                binding.num1Mvp.setText("")
                binding.num2Mvp.setText("")
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
                binding.num1Mvp.setText("")
                binding.num2Mvp.setText("")
            }
        }

        multButton.setOnClickListener {
            if (binding.num1Mvp.text.toString() != "" && binding.num2Mvp.text.toString() != "") {
                res = presenter!!.onMultiplyButtonClick(
                    binding.num1Mvp.text.toString().toDouble(),
                    binding.num2Mvp.text.toString().toDouble()
                )
                Toast.makeText(requireActivity(), "Successful operation.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireActivity(), "Invalid operation.", Toast.LENGTH_SHORT).show()
                binding.num1Mvp.setText("")
                binding.num2Mvp.setText("")
            }
        }

        divButton.setOnClickListener {
            if (binding.num1Mvp.text.toString() != "" && binding.num2Mvp.text.toString() != "") {
                res = presenter!!.onDivideButtonClick(
                    binding.num1Mvp.text.toString().toDouble(),
                    binding.num2Mvp.text.toString().toDouble()
                )
                if (res == null) {
                    Toast.makeText(requireActivity(), "Invalid operation.", Toast.LENGTH_SHORT).show()
                    binding.num1Mvp.setText("")
                    binding.num2Mvp.setText("")
                } else {
                    Toast.makeText(requireActivity(), "Successful operation.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireActivity(), "Invalid operation.", Toast.LENGTH_SHORT).show()
                binding.num1Mvp.setText("")
                binding.num2Mvp.setText("")
            }

        }
        return view
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        savedInstanceState.putString("result", binding.resultMvp.text.toString())
        super.onSaveInstanceState(savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}