package com.template.lovecompatibilitykg.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.template.lovecompatibilitykg.retrofit.LoveModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoveViewModel @Inject constructor(private val repository: Repository) : ViewModel(),
    java.io.Serializable {
    fun getLiveData(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getPercentage(firstName, secondName)
    }
}