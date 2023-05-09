package com.example.jetpacknav.data

import com.example.jetpacknav.data.remote.APIFactory
import com.example.jetpacknav.data.remote.model.AnimalAPIModel

object AnimalRepository {
    private val api = APIFactory.animalApi

    suspend fun getFact(): AnimalAPIModel? {
        val parameters = HashMap<String, String>()
        parameters.put("animal_type", "cat")
        parameters.put("amount", "1")

        val response = api.getFact(parameters)
        if(response.isSuccessful){
            if(response.body() != null){
                val body = response.body()
                return body!!
            }
        }
        return null
    }
}