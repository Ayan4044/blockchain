package com.ayan.blockchain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.ayan.blockchain.databinding.ActivityMainBinding
import com.ayan.blockchain.fragments.FragmentMarket
import com.ayan.blockchain.fragments.FragmentTrade
import com.ayan.blockchain.fragments.FragmentWallet
import com.ayan.blockchain.fragments.Fragment_home

class MainActivity : AppCompatActivity() {
    //view binding
    private lateinit var _mainactivitybinding: ActivityMainBinding

    //view model
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _mainactivitybinding = ActivityMainBinding.inflate(layoutInflater)

        mainViewModel =    ViewModelProvider(this).get(MainViewModel::class.java)

        mainViewModel.loadHospitalist()

        setContentView(_mainactivitybinding.root)


        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container,
            Fragment_home()
        ).commit()

        _mainactivitybinding.bottomNavigationView.setOnItemSelectedListener{
            when (it.itemId) {
                R.id.home -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fragment_container,
                        Fragment_home()
                    ).commit()
                    return@setOnItemSelectedListener true
                }
                R.id.market -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fragment_container,
                        FragmentMarket()
                    ).commit()
                    return@setOnItemSelectedListener true
                }
                R.id.trade -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fragment_container,
                        FragmentTrade()
                    ).commit()
                    return@setOnItemSelectedListener true
                }
                R.id.wallet -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fragment_container,
                        FragmentWallet()
                    ).commit()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }

    }
}