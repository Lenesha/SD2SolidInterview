package com.example.sd2.di.network

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("has_more") val has_more: Boolean,
    @SerializedName("users") val users: List<User>
)