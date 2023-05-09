package com.example.jetpacknav.presentation.first_fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpacknav.data.local.model.Animal
import com.example.jetpacknav.domain.AnimalUseCase
import kotlinx.coroutines.launch

class FirstFragmentViewModel : ViewModel(){

    private val animalUseCase = AnimalUseCase

    val animals = MutableLiveData<ArrayList<Animal>>()
    val fact = MutableLiveData<String>()
    val isLoading = MutableLiveData<Boolean>()

    fun getFact() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val data = animalUseCase.getFact()
            fact.postValue(data)
            isLoading.postValue(false)
        }
    }

    fun getAnimals(){
        viewModelScope.launch {
            val data = animalUseCase.getAnimals()
            animals.postValue(data)
        }
    }
}