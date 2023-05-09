package com.example.jetpacknav.presentation.first_fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.jetpacknav.data.local.model.Animal
import com.example.jetpacknav.R

class AnimalAdapter(
    val listner: Listener
) :RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>()  {

    var animals = ArrayList<Animal>()

    class AnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var textViewAnimalName : TextView = itemView.findViewById(R.id.nameOfAnmal)
        var textViewAnimalShortDescription : TextView = itemView.findViewById(R.id.shortDesciption)
        var image : ImageView = itemView.findViewById(R.id.imageAnimal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {

        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.animal_card,parent,false)
        return AnimalViewHolder(view)
    }

    override fun getItemCount(): Int {
        return animals.size
    }


    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            listner.onClick(position)
        }
        Glide.with(holder.itemView.context)
            .load(animals.get(position).urlPhoto).fitCenter().into(holder.image)
        holder.textViewAnimalName.text = animals.get(position).name
        holder.textViewAnimalShortDescription.text = animals.get(position).shortDescription
    }

    fun setArrayListOfAnimals(animals : ArrayList<Animal>){
        this.animals.clear()
        this.animals.addAll(animals)
        notifyDataSetChanged()
    }

    interface Listener {
        fun onClick(itemView: Int)
    }
}