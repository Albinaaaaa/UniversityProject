package com.example.jetpacknav.data.remote

import com.example.jetpacknav.data.remote.model.AnimalAPIModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface AnimalAPIInterface {
    @GET("/facts/random")
    suspend fun getFact(@QueryMap parameters: Map<String, String>) : Response<AnimalAPIModel>
}