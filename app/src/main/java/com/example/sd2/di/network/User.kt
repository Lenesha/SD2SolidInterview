package com.example.sd2.di.network

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("image")  val image: String,
    @SerializedName("items")  val items: List<String>,
    @SerializedName("name")  val name: String
)