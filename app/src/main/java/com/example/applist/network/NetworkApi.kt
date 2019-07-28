package com.example.applist.network

import com.example.applist.model.FactsListModel
import retrofit2.Call
import retrofit2.http.GET

/*
* Code by Yogesh
* */

interface NetworkApi {
    @GET("/s/2iodh4vg0eortkl/facts.json")
    fun getFacts(): Call<FactsListModel>

}