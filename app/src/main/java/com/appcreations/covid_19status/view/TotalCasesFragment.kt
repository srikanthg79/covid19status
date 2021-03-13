package com.appcreations.covid_19status.view


import android.content.Context
import android.net.ConnectivityManager
import android.opengl.Visibility
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.appcreations.covid_19status.R
import com.appcreations.covid_19status.viewmodel.TotalCasesFragmentViewModel
import kotlinx.android.synthetic.main.activity_country_detail.*
import kotlinx.android.synthetic.main.fragment_total_cases.*
import kotlinx.android.synthetic.main.fragment_total_cases.date
import kotlin.concurrent.thread

/**
 * A simple [Fragment] subclass.
 */
class TotalCasesFragment : Fragment() {

    private var viewModel: TotalCasesFragmentViewModel? = null

    // private TotalCasesFragmentViewModel viewModel;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_total_cases, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //viewModel = ViewModelProviders.of(this).get(InsertViewModel.class);

        viewModel = ViewModelProvider(this).get(TotalCasesFragmentViewModel::class.java)

        val connection: ConnectivityManager? =
            context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connection?.activeNetworkInfo != null) {
            viewModel?.getTotalCovid19()?.observe(this, Observer {
                if (it != null) {
                    totalCasesProgressBar.visibility = View.GONE
                    date.text = it.data[0].date
                    totalConfirmedValue.text = it.data[0].confirmed.toString()
                    totalRecoveredValue.text = it.data[0].recovered.toString()
                    totalDeathValue.text = it.data[0].deaths.toString()
                }
            })
        } else {
            viewModel?.getTotalCases()?.observe(this, Observer {

                if (it != null) {
                    totalCasesProgressBar.visibility = View.GONE
                    date.text = it.date + " (No Internet - Old Data)"
                    totalConfirmedValue.text = it.confirmed.toString()
                    totalRecoveredValue.text = it.recovered.toString()
                    totalDeathValue.text = it.deaths.toString()
                }
            })
        }
    }
}
