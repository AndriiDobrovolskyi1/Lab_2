package com.andrii.lab_2


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class Adapter(private val countries: List<Countries>) : RecyclerView.Adapter<Adapter.MyViewHolder>() {



    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val name: TextView = itemView.findViewById(R.id.name)
        val image: ImageView = itemView.findViewById(R.id.image)
        val shortDescription: TextView = itemView.findViewById(R.id.shortDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val country = countries[position]
        holder.name.text = country.name
        Glide.with(holder.itemView)
            .load(country.image)
            .into(holder.image)
        holder.shortDescription.text = country.shortDescription
        holder.itemView.setOnClickListener { view ->
            val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(country)
            view.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int = countries.size
}