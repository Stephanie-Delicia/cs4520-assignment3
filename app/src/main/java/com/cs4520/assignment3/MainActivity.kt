package com.cs4520.assignment3

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import com.cs4520.assignment3.ui.theme.Assignment3Theme

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ViewDataBinding>(this, R.layout.activity_layout)

        // setContentView(R.layout.activity_layout)
    }
}