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

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        Log.d("onViewCreated", "FragmentMvvmBinding")
//        var binding = DataBindingUtil.setContentView<FragmentMvvmBinding>(requireActivity(), R.layout.fragment_mvvm)
//        binding.addButtonMvvm.setOnClickListener {
//            Toast.makeText(requireActivity(), "Dawg what is going on admin", Toast.LENGTH_SHORT).show()
//            Log.i("Pressed add button", "In fragment")
//            var v = bindingFragment.viewModel
//            if (v != null) {
//                v.onAddSubtractOrMultiplyButtonClicked()
//            } else {Log.i("view model null?", "yup")}
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingFragment = DataBindingUtil.inflate(inflater, R.layout.fragment_mvvm, container, false)
        bindingFragment.lifecycleOwner = viewLifecycleOwner
        bindingFragment.setViewModel(ViewModel())
        bindingFragment.executePendingBindings()
        // bindingFragment = FragmentMvvmBinding.inflate(inflater).also { bindingFragment = it }
        Log.d("onCreateView", "FragmentMvvmBinding")
        Log.i("Is binding null?", bindingFragment.toString())
        var add = bindingFragment.addButtonMvvm
        Log.i("Is add Button null?", add.toString())
        add.setOnClickListener {
            Toast.makeText(requireActivity(), "Dawg what is going on admin", Toast.LENGTH_SHORT).show()
            Log.i("Pressed add button", "In fragment")
            var v = bindingFragment.viewModel
            if (v != null) {
                v.onAddSubtractOrMultiplyButtonClicked()
            } else {Log.i("view model null?", "yup")}
        }
        return bindingFragment.root
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