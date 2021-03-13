package com.appcreations.covid_19status.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.appcreations.covid_19status.view.CountryCasesFragment
import com.appcreations.covid_19status.view.TotalCasesFragment

class SwipeViewAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment =
        if(position==0)TotalCasesFragment() else CountryCasesFragment()

}