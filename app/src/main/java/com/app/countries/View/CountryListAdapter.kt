package com.app.countries.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.countries.Model.Country
import com.app.countries.R
import com.app.countries.Util.loadImage
import kotlinx.android.synthetic.main.item_country.view.*

class CountryListAdapter(var countries: ArrayList<Country>): RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {


    fun updateCountries(newCountries: List<Country>){
        countries.clear()
        countries.addAll(newCountries)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CountryViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
    )

    override fun getItemCount(): Int {
      return countries.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {

        holder.bind(countries[position])
    }

    class CountryViewHolder(view: View): RecyclerView.ViewHolder(view){

        val countryName = view.name
        val capital = view.capital
        val flagImage = view.flag


        fun bind(country: Country){
             countryName.text= country.countryname
             capital.text = country.capital
             flagImage.loadImage(country.flagPng)
        }
    }
}