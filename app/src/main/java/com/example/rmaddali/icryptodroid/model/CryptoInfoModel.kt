package com.example.rmaddali.icryptodroid.model


data class CryptoInfoModel(
    val status: Status,
    val data: List<Data>
)



data class Status(
    val timestamp: String,
    val error_code: Int,
    val error_message: Any,
    val elapsed: Int,
    val credit_count: Int
)