package com.template.lovecompatibilitykg.mvvm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.template.lovecompatibilitykg.retrofit.LoveApi
import com.template.lovecompatibilitykg.retrofit.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/**
 * Author: Dzhaparov Bekmamat
 */
class Repository @Inject constructor(private val loveApi: LoveApi) {
    fun getPercentage(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        val liveData = MutableLiveData<LoveModel>()
        loveApi.getPercentage(firstName, secondName)
            .enqueue(object : Callback<LoveModel> {
                override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                    liveData.postValue(response.body())
                }

                override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                    Log.e("ololo", t.message.toString())
                }
            })
        return liveData
    }
}