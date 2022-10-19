package com.example.kabaddiapp.feature_kabaddi.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "result_table")
data class KabaddiResult(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "team_id")
    val id : Int,


    @ColumnInfo(name = "TeamA")
    val teamA : String,
    @ColumnInfo(name = " TeamB")
    val teamB : String,
    @ColumnInfo(name = "Time")
    val time : String,

)
