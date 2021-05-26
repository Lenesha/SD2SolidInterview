package com.example.sd2.di.network

import com.google.gson.annotations.SerializedName

data class NetworkResponse(
    @SerializedName("data") val `data`: Data,
    @SerializedName("message") val message: Any,
    @SerializedName("status") val status: Boolean
)