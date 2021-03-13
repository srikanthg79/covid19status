package com.appcreations.covid_19status.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreferenceCompat
import com.appcreations.covid_19status.R

/**
 * A simple [Fragment] subclass.
 */
class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {

        setPreferencesFromResource(R.xml.settings, rootKey)

        findPreference<SwitchPreferenceCompat>("darkMode")?.isIconSpaceReserved = false

        activity?.setTheme(R.style.PreferenceStyle)

    }

}




