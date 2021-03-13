package com.appcreations.covid_19status.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.appcreations.covid_19status.R
import com.appcreations.covid_19status.model.pojos.Covid19Countries
import com.appcreations.covid_19status.view.CountryDetailActivity
import kotlinx.android.synthetic.main.country_cases_rv_item.view.*


class CountryCasesRVAdapter(private val countries: Covid19Countries) :
    RecyclerView.Adapter<CountryCasesRVAdapter.CountryCasesViewHolder>() {

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryCasesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.country_cases_rv_item, parent, false)
        context = parent.context
        return CountryCasesViewHolder(view)
    }

    override fun getItemCount(): Int = countries.data.size

    override fun onBindViewHolder(holder: CountryCasesViewHolder, position: Int) {
        holder.itemView.countryName.text = countries.data[position].name
        holder.itemView.deathValue.text = countries.data[position].latestData.deaths.toString()
        holder.itemView.confirmValue.text = countries.data[position].latestData.confirmed.toString()
        holder.itemView.recoveredValue.text = countries.data[position].latestData.recovered.toString()
        holder.itemView.rootView.setOnClickListener(View.OnClickListener {

            var intent = Intent(context, CountryDetailActivity::class.java)
            intent.putExtra("country_code", countries.data[position].code)
            context.startActivity(intent)
        })

        holder.itemView.countryName.setOnClickListener(View.OnClickListener {

        })
    }

    class CountryCasesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}