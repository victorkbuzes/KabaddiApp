package com.example.kabaddiapp.feature_kabaddi.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kabaddiapp.feature_kabaddi.data.KabaddiRepoitory
import com.example.kabaddiapp.feature_kabaddi.data.KabaddiResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "KabaddiViewModel"
class KabaddiViewModel(private  val repository: KabaddiRepoitory): ViewModel() {
    init {
        getResults()
    }

    val historyData = repository.getSavedResults()


    private val _history = mutableStateOf<List<KabaddiResult>>(emptyList())
    val history: State<List<KabaddiResult>> = _history

//counter B
    private val _counterB = mutableStateOf(0)
    val counterB: State<Int> = _counterB
//counter A
    private val _counterA = mutableStateOf(0)
    val counterA: State<Int> = _counterA



    fun resetCounter() {
        _counterB.value = 0
        _counterA.value = 0
    }


    fun incrementTeamABy1(){
        _counterA.value  ++
    }
    fun  incrementTeamAby2(){
        _counterA.value = _counterA.value + 2
    }


    fun incrementTeamBby1(){
        _counterB.value ++
    }
    fun  incrementTeamBby2(){
        _counterB.value = _counterB.value + 2
    }

    fun  addResult(teamA: String, teamB: String, time: String){
        viewModelScope.launch (Dispatchers.IO){
            repository.insertResult(KabaddiResult(0, teamA, teamB, time))
        }
    }

    fun  getResults(){
        val results = repository.getSavedResults().value
        Log.d(TAG, "getResults: $results")
//        _history.value = results ?: emptyList()
    }

    fun removeResult(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllResults()
        }

    }


}
