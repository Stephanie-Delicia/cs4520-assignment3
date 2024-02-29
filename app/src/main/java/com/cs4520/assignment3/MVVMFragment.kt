package com.cs4520.assignment3

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.cs4520.assignment3.databinding.FragmentMvvmBinding
class MVVMFragment : Fragment() {
    private lateinit var bindingFragment: FragmentMvvmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingFragment = DataBindingUtil.inflate(inflater, R.layout.fragment_mvvm, container, false)
        bindingFragment.lifecycleOwner = viewLifecycleOwner
        bindingFragment.viewModel = ViewModel()
        bindingFragment.executePendingBindings()
        Log.d("onCreateView", "FragmentMvvmBinding")
        val add = bindingFragment.addButtonMvvm
        val sub = bindingFragment.subButtonMvvm
        val mult = bindingFragment.multButtonMvvm
        val div = bindingFragment.divButtonMvvm

        val v = bindingFragment.viewModel
        if (savedInstanceState != null)
        {
            val result = savedInstanceState.getString("result", "")
            val s = getString(R.string.result) + " " + result
            bindingFragment.resultMvvm.text = s
        }

        if (v != null) {
            add.setOnClickListener {
                v.setNum1(bindingFragment.num1Mvvm.text.toString())
                v.setNum2(bindingFragment.num2Mvvm.text.toString())
                v.onAddClicked()
                val result = v.getResult().toString()
                if (result != "null") {
                    val s = getString(R.string.result) + " " + result
                    bindingFragment.resultMvvm.text = s
                }
                v.setNum1(null)
                v.setNum2(null)
                bindingFragment.num1Mvvm.setText("")
                bindingFragment.num2Mvvm.setText("")
            }
            sub.setOnClickListener {
                v.setNum1(bindingFragment.num1Mvvm.text.toString())
                v.setNum2(bindingFragment.num2Mvvm.text.toString())
                v.onSubtractClicked()
                val result = v.getResult().toString()
                if (result != "null") {
                    val s = getString(R.string.result) + " " + result
                    bindingFragment.resultMvvm.text = s
                }
                //Toast.makeText(requireActivity(), v.getToastMessage(), Toast.LENGTH_SHORT).show()
                v.setNum1(null)
                v.setNum2(null)
                bindingFragment.num1Mvvm.setText("")
                bindingFragment.num2Mvvm.setText("")
            }
            mult.setOnClickListener {
                v.setNum1(bindingFragment.num1Mvvm.text.toString())
                v.setNum2(bindingFragment.num2Mvvm.text.toString())
                v.onMultiplyClicked()
                val result = v.getResult().toString()
                if (result != "null") {
                    val s = getString(R.string.result) + " " + result
                    bindingFragment.resultMvvm.text = s
                }
                //Toast.makeText(requireActivity(), v.getToastMessage(), Toast.LENGTH_SHORT).show()
                v.setNum1(null)
                v.setNum2(null)
                bindingFragment.num1Mvvm.setText("")
                bindingFragment.num2Mvvm.setText("")
            }
            div.setOnClickListener {
                v.setNum1(bindingFragment.num1Mvvm.text.toString())
                v.setNum2(bindingFragment.num2Mvvm.text.toString())
                v.onDivideClicked()
                val result = v.getResult().toString()
                if (result != "null") {
                    val s = getString(R.string.result) + " " + result
                    bindingFragment.resultMvvm.text = s
                }
                //Toast.makeText(requireActivity(), v.getToastMessage(), Toast.LENGTH_SHORT).show()
                v.setNum1(null)
                v.setNum2(null)
                bindingFragment.num1Mvvm.setText("")
                bindingFragment.num2Mvvm.setText("")
            }
        }
        return bindingFragment.root
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.
        savedInstanceState.putString("result", bindingFragment.resultMvvm.text.toString())
        super.onSaveInstanceState(savedInstanceState)
    }
}

// any change in toastMessage attribute
// defined on the Button with bind prefix
// invokes this method
@BindingAdapter("toastMessage")
fun runMe(view: View, message: String?) {
    Log.i("toastMessage", "Fragment")
    if (message != null) Toast
        .makeText(
            view.context, message,
            Toast.LENGTH_SHORT
        )
        .show()
}