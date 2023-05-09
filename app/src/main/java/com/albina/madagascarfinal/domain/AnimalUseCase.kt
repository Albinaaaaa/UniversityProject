package com.example.jetpacknav.domain

import com.example.jetpacknav.data.local.model.Animal
import com.example.jetpacknav.data.AnimalRepository
import com.example.jetpacknav.data.local.AnimalsDB

object AnimalUseCase {

    private val animalRepository = AnimalRepository
    private val localDB = AnimalsDB()

    suspend fun getFact() : String{
        return animalRepository.getFact()?.text?:String()
    }

    fun getAnimals() : ArrayList<Animal>{
        val animals = localDB.getAnimals()
        return animals
    }
}
