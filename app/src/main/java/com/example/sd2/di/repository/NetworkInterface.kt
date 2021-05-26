package com.example.sd2.di.repository

import com.example.sd2.di.network.NetworkResponse
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*


interface NetworkInterface {
    @GET("/api/users")
    fun loadPosts(@Query("offset")offset:Int,@Query("limit")limit:Int ): Single<NetworkResponse>
}