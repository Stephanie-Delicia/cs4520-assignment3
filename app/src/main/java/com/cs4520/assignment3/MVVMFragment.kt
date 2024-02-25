package com.cs4520.assignment3

import android.annotation.SuppressLint
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
        add.setOnClickListener {
            onButtonClicked(Operation.ADD)
        }
        sub.setOnClickListener {
            onButtonClicked(Operation.SUBTRACT)
        }
        mult.setOnClickListener {
            onButtonClicked(Operation.MULTIPLY)
        }
        div.setOnClickListener {
            onButtonClicked(Operation.DIVIDE)
        }
        return bindingFragment.root
    }

    @SuppressLint("SetTextI18n")
    fun onButtonClicked(op: Operation) {
        Log.i("Button clicked.", "In MVVM fragment.")
        val v = bindingFragment.viewModel
        v.setNum1(bindingFragment.num1Mvvm.text.toString().toDouble())
        v.setNum2(bindingFragment.num2Mvvm.text.toString().toDouble())
        if (v != null) {
            v.onOperationButtonClicked(op)
            bindingFragment.resultMvvm.text = "@string/result" + v.getResult().toString()
        } else {
            Log.i("Null button.", "In fragment.")
        }
    }
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