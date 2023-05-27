package com.andrii.lab_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide


class DetailsFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args: DetailsFragmentArgs by navArgs ()
        val country = args.transfer
        val name: TextView = view.findViewById(R.id.nameCountry)
        val image: ImageView = view.findViewById(R.id.imageView)
        val description: TextView = view.findViewById(R.id.description)
        name.text = country.name
        Glide.with(view)
            .load(country.image)
            .into(image)
        description.text = country.description
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_details, container, false)
        val button = rootView.findViewById<Button>(R.id.button)
        button.setOnClickListener{
            findNavController().navigate(R.id.action_detailsFragment_to_homeFragment)
        }
        return rootView
    }


}