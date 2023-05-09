package com.example.jetpacknav.data.local

import com.example.jetpacknav.data.local.model.Animal
import com.example.jetpacknav.domain.AnimalUseCase

class AnimalsDB {
    var lion = Animal("Alex", "Lion", "https://m.jumpstart.com/JumpstartNew/Dreamworks/Images/MAD_Bio_Images/Alex_bio_01.png", "Alex is extremely conservative. His future was set from the moment he was born. “Silver spoon syndrome” squared. Having been born into a privileged life, he never had to prove himself. Alex has never had to work a day in his life, and the idea of work is absolutely repugnant to him!")
    var zebra = Animal("Marty", "Zebra","https://m.jumpstart.com/JumpstartNew/Dreamworks/Images/MAD_Bio_Images/Marty_bio_02.png", "Marty is the guy that everybody loves to be around. He has always made friends easily because he has a way of making others feel good about themselves.")
    var mouse = Animal ("Mort", "Squirrel", "https://static.wikia.nocookie.net/penguinsofmadagascar/images/f/f8/Ahkjmort.png/revision/latest?cb=20190727144938", "Wacky, outlandish, and mostly annoying, King Julien ensures that the entertainment never stops!")


    fun getAnimals() : ArrayList<Animal>{
        val animals = ArrayList<Animal>()
        animals.add(lion)
        animals.add(zebra)
        animals.add(mouse)
        return animals
    }
}