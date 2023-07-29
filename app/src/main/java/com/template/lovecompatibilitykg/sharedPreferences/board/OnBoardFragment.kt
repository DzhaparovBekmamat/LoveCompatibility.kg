package com.template.lovecompatibilitykg.sharedPreferences.board

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import com.template.lovecompatibilitykg.R
import com.template.lovecompatibilitykg.databinding.FragmentOnBoardBinding
import com.template.lovecompatibilitykg.sharedPreferences.utils.Preferences
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardFragment : Fragment() {
    @Inject
    lateinit var pref: Preferences

    private lateinit var binding: FragmentOnBoardBinding
    private val adapter = BoardAdapter(this::click)

    private fun click() {
        pref.saveBoardState()
        findNavController().navigate(R.id.enterFragment)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager.adapter = adapter
        TabLayoutMediator(binding.wormDotsIndicator, binding.viewPager) { tab, _ ->
            tab.setIcon(R.drawable.tab_indicator)
        }.attach()
        binding.skipButton.setOnClickListener {
            val currentItem = binding.viewPager.currentItem
            binding.viewPager.setCurrentItem(currentItem + 2, true)
        }
        binding.nextButton.setOnClickListener {
            val currentItem = binding.viewPager.currentItem
            binding.viewPager.setCurrentItem(currentItem + 1, true)
        }
    }
}
