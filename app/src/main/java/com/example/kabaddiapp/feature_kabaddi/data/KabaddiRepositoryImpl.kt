package com.example.kabaddiapp.feature_kabaddi.data

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow

class KabaddiRepositoryImpl(private  val dao: KabaddiDao): KabaddiRepoitory {
    override suspend fun insertResult(result: KabaddiResult) {
        dao.insertResult(result)
    }

    override suspend fun deleteResult(result: KabaddiResult) {
        dao.deleteResult(result)
    }

    override suspend fun deleteAllResults() {
        dao.deleteAll()
    }

    override fun getSavedResults(): LiveData<List<KabaddiResult>> {
        return dao.getResults()
    }
}