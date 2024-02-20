package com.cs4520.assignment3

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import com.cs4520.assignment3.ui.theme.Assignment3Theme

class MainActivity : FragmentActivity() {

    // private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_layout)
    }
}