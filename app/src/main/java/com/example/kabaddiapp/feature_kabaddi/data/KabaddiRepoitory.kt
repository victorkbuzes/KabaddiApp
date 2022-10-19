package com.example.kabaddiapp.feature_kabaddi.data

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow

interface KabaddiRepoitory {
    suspend fun  insertResult (result: KabaddiResult)
    suspend fun  deleteResult (result: KabaddiResult)
    suspend fun deleteAllResults()
    fun getSavedResults(): LiveData<List<KabaddiResult>>
}