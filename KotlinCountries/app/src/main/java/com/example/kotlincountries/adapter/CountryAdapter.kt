package com.example.kotlincountries.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincountries.R
import com.example.kotlincountries.databinding.ItemCountryBinding
import com.example.kotlincountries.model.Country
import com.example.kotlincountries.util.downloadFromUrl
import com.example.kotlincountries.util.placeholderProgressBar
import com.example.kotlincountries.view.FeedFragment
import com.example.kotlincountries.view.FeedFragmentDirections
import kotlinx.android.synthetic.main.item_country.view.*

class CountryAdapter(val countryList: ArrayList<Country>) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>(), CountryClickListener {

    class CountryViewHolder(var view: ItemCountryBinding) : RecyclerView.ViewHolder(view.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        //val view = inflater.inflate(R.layout.item_country, parent, false)
        val view = DataBindingUtil.inflate<ItemCountryBinding>(
            inflater,
            R.layout.item_country,
            parent,
            false
        )
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {

        holder.view.country = countryList[position]
        holder.view.listener = this

        /*holder.view.countryName.text = countryList[position].countryName
        holder.view.countryRegion.text = countryList[position].countryRegion

        holder.view.setOnClickListener {
            val action =
                FeedFragmentDirections.actionFeedFragmentToDetailFragment(countryList[position].uuid)

            Navigation.findNavController(it).navigate(action)
        }
        holder.view.countryImage.downloadFromUrl(
            countryList[position].countryUrl,
            placeholderProgressBar(holder.view.context)
        )*/

    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateCountryList(newCountryList: List<Country>) {
        countryList.clear()
        countryList.addAll(newCountryList)
        notifyDataSetChanged()
    }

    override fun onCountryClicked(v: View) {
        val uuid = v.countryUuidText.text.toString().toInt()
        val action =
            FeedFragmentDirections.actionFeedFragmentToDetailFragment(uuid)
        Navigation.findNavController(v).navigate(action)
    }
}