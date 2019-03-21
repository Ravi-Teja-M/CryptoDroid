package com.example.rmaddali.icryptodroid.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rmaddali.icryptodroid.model.Data

@Dao
interface CoinDataDAO  {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCoinData(coinList: List<Data>)

    @Query("select * from Coins ")
     fun getAllCoinsList() : List<Data>

}