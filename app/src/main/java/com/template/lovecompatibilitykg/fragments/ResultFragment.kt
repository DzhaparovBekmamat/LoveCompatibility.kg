package com.template.lovecompatibilitykg.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.template.lovecompatibilitykg.databinding.FragmentResultBinding
import com.template.lovecompatibilitykg.retrofit.LoveModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@Suppress("DEPRECATION")
class ResultFragment : Fragment() {
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!
    private var loveModel: LoveModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loveModel = arguments?.getSerializable(EnterFragment.KEY) as LoveModel
        initializeTextView()
        initializeClickers()
    }

    private fun initializeClickers() {
        with(binding) {
            buttonBack.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun initializeTextView() {
        with(binding) {
            textView1.text = loveModel?.firstName.toString()
            textView2.text = loveModel?.secondName.toString()
            result.text = loveModel?.percentage.toString() + "%"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
