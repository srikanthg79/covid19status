package com.appcreations.covid_19status.view


import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.appcreations.covid_19status.R
import com.appcreations.covid_19status.adapters.CountryCasesRVAdapter
import com.appcreations.covid_19status.viewmodel.CountryCasesFragmentViewModel
import kotlinx.android.synthetic.main.fragment_country_cases.*

/**
 * A simple [Fragment] subclass.
 */
class CountryCasesFragment : Fragment() {

    private var viewModel: CountryCasesFragmentViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_country_cases, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        country_cases_recycler_view.layoutManager = LinearLayoutManager(activity)

        //Create viewmodel instance
        viewModel = ViewModelProvider(this).get(CountryCasesFragmentViewModel::class.java)

        val connection: ConnectivityManager? =
            context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connection?.activeNetworkInfo != null) {
            viewModel?.getCountriesCovid19()?.observe(this, Observer {

                if (it != null) {
                    countryCasesProgressBar.visibility = View.GONE
                    country_cases_recycler_view.adapter = CountryCasesRVAdapter(it)
                }else{
                    countryCasesProgressBar.visibility = View.GONE
                }
            })
        } else {
            countryCasesNoInternet.visibility = View.VISIBLE
            countryCasesProgressBar.visibility = View.GONE
        }

    }
}
