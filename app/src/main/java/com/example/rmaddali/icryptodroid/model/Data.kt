package com.example.rmaddali.icryptodroid.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Coins")
class Data(

        @PrimaryKey
        @NonNull
        val id: Int,
        val name: String,
        val symbol: String,
        val slug: String,
        val is_active: Int,
        val first_historical_data: String,
        val last_historical_data: String
)