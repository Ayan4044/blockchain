package com.ayan.blockchain.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ayan.blockchain.fragments.Fragment_Spot
import com.ayan.blockchain.fragments.Fragment_Zone

class TabAdapter (fm: FragmentActivity, lifecycle: Lifecycle) :
    FragmentStateAdapter(fm) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> Fragment_Zone()
            // 1 -> Fragment_DonationAppointment()
            1 -> Fragment_Spot()
            else -> Fragment_Zone()
        }
    }



}