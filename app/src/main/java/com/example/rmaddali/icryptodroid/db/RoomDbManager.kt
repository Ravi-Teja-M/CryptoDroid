package com.example.rmaddali.icryptodroid.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.rmaddali.icryptodroid.db.dao.CoinDataDAO
import com.example.rmaddali.icryptodroid.model.Data

@Database(version = 1 , entities = [Data::class])
 abstract  class RoomDbManager : RoomDatabase() {


    abstract fun  getCoinDataDao() : CoinDataDAO

    companion object {
         var instance : RoomDbManager ? = null

        fun getInstance(appContext: Context): RoomDbManager {
            if(instance==null){
                instance = Room.databaseBuilder(appContext,RoomDbManager::class.java,"CoinDB").build()
            }
            return instance as RoomDbManager
        }
     }
}