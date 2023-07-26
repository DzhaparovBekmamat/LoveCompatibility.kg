package com.template.lovecompatibilitykg.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.template.lovecompatibilitykg.mvvm.LoveViewModel
import com.template.lovecompatibilitykg.R

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private val viewModel: LoveViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = Navigation.findNavController(this, R.id.host_fragment)
    }
}
