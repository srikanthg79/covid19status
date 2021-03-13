package com.appcreations.covid_19status.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.appcreations.covid_19status.R
import com.appcreations.covid_19status.adapters.SwipeViewAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_statistics.*

/**
 * A simple [Fragment] subclass.
 */
class StatisticsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_statistics, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val swipeViewAdapter = SwipeViewAdapter(this)
        viewpager2.adapter = swipeViewAdapter
        TabLayoutMediator(tab_layout, viewpager2,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                when (position) {
                    0 -> {
                        tab.text = getString(R.string.global_fragment_label)
                    }
                    1 -> {
                        tab.text = "Countries"
                    }
                }
            }).attach()
    }

}


