package com.template.lovecompatibilitykg.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.template.lovecompatibilitykg.R
import com.template.lovecompatibilitykg.databinding.FragmentEnterBinding

class EnterFragment : Fragment() {
    private lateinit var binding: FragmentEnterBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentEnterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        send()
    }

    private fun send() {
        with(binding) {
            button.setOnClickListener {
                val fname = editTextFname.text.toString()
                val sname = editTextSname.text.toString()
                val bundle = Bundle()
                bundle.putString(
                    "fname", fname
                )
                bundle.putString(
                    "sname", sname
                )
                findNavController().navigate(R.id.resultFragment, bundle)
            }
        }
    }
}
