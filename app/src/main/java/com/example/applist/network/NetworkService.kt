package com.example.applist.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
* Code by Yogesh
* */

object NetworkService {

    val instance : NetworkApi by lazy {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://dl.dropboxusercontent.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(NetworkApi::class.java)
    }
}