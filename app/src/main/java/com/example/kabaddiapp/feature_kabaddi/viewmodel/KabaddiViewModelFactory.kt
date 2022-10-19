package com.example.kabaddiapp.feature_kabaddi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kabaddiapp.feature_kabaddi.data.KabaddiRepoitory

class KabaddiViewModelFactory(private val repository: KabaddiRepoitory): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =  KabaddiViewModel(repository) as T

}