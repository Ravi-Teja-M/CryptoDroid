package com.example.rmaddali.icryptodroid.model

data class CryptoInfoModel(
    val status: Status,
    val data: List<Data>
)

data class Data(
    val id: Int,
    val name: String,
    val symbol: String,
    val slug: String,
    val is_active: Int,
    val first_historical_data: String,
    val last_historical_data: String
)

data class Status(
    val timestamp: String,
    val error_code: Int,
    val error_message: Any,
    val elapsed: Int,
    val credit_count: Int
)