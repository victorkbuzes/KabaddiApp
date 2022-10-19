package com.example.kabaddiapp.feature_kabaddi.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room

import androidx.room.RoomDatabase


@Database(entities = [KabaddiResult::class], version = 1)
abstract class KabaddiDatabase: RoomDatabase()  {
    abstract  val kabaddiDao:KabaddiDao

    companion object{
        @Volatile
        private  var INSTANCE : KabaddiDatabase? = null
        fun getInstance(context: Context): KabaddiDatabase{
            synchronized(this){
                var instance = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        KabaddiDatabase::class.java,
                        "kabaddi_database"

                    ).build()

                }
                return  instance


            }
        }
    }

}
