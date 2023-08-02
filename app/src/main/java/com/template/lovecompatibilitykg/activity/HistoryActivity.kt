package com.template.lovecompatibilitykg.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.template.lovecompatibilitykg.databinding.ActivityHistoryBinding
import com.template.lovecompatibilitykg.mvvm.LoveViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHistoryBinding
    private val loveViewModel: LoveViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loveViewModel.getAll().observe(this@HistoryActivity) {
            binding.textView.text = it
        }
    }
}
