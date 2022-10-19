package com.example.kabaddiapp.feature_kabaddi.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface KabaddiDao {


    @Insert
    suspend fun  insertResult(result: KabaddiResult)

    @Delete
    suspend fun  deleteResult(result: KabaddiResult)

    @Query("DELETE FROM result_table")
    suspend fun  deleteAll()

    @Query("SELECT * FROM result_table")
    fun getResults() : LiveData<List<KabaddiResult>>


}