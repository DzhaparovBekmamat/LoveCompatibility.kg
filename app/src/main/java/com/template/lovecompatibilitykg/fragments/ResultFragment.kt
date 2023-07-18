package com.template.lovecompatibilitykg.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.template.lovecompatibilitykg.R
import com.template.lovecompatibilitykg.databinding.FragmentResultBinding
import com.template.lovecompatibilitykg.retrofit.LoveModel
import com.template.lovecompatibilitykg.retrofit.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
    }

    private fun initClicker() {
        if (arguments != null) {
            with(binding) {
                textView1.text = arguments!!.getString("fname")
                textView2.text = arguments!!.getString("sname")
                RetrofitService().api.getPercentage(
                    textView1.text.toString(), textView2.text.toString()
                ).enqueue(object : Callback<LoveModel> {
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        result.text = response.body()!!.percentage
                    }

                    @SuppressLint("SetTextI18n")
                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        result.text = "Error: ${t.message}"
                    }
                })
                buttonBack.setOnClickListener {
                    findNavController().navigate(R.id.enterFragment)
                }
            }
        }
    }
}
