package com.ayan.blockchain.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModelProvider
import com.ayan.blockchain.MainViewModel
import com.ayan.blockchain.R
import com.ayan.blockchain.adapter.CryptoRecylerAdapter
import com.ayan.blockchain.adapter.TabAdapter
import com.ayan.blockchain.databinding.FragmentMarketBinding
import com.ayan.blockchain.model.DataClassCrypto
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentMarket.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentMarket : Fragment(), LifecycleObserver {

    //recycler view
    private lateinit var cryptoRecylerAdapter: CryptoRecylerAdapter
    private lateinit var cryptolist: ArrayList<DataClassCrypto>

    //viewmodel
    private lateinit var mainViewModel: MainViewModel

    //viewbinding
    private var _binding: FragmentMarketBinding? = null
    private val binding get() = _binding!!
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMarketBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
     binding.viewtabAdapter.adapter=   TabAdapter(requireActivity() ,requireActivity().lifecycle)

        TabLayoutMediator(
            binding.tabLayoutProfle,   binding.viewtabAdapter
        ) { tab: TabLayout.Tab, position: Int -> when(position){
            0->tab.text = "Zones "
            //  1-> tab.text = "Appointment "
            1-> tab.text = "Spot "
        } }.attach()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentMarket.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentMarket().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
//
//    @OnLifecycleEvent(Lifecycle.Event.ON_START)
//    fun onStarted(){
//        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
//
//        mainViewModel.liveviewStockData.observe(viewLifecycleOwner){
//            liveDataCryptoList ->
//                if(liveDataCryptoList != null){
//                    cryptolist.clear()
//                    cryptolist.addAll(liveDataCryptoList)
//                    binding.recyclerviewCrypto.adapter = cryptoRecylerAdapter
//                }
//        }
//    }



    override fun onAttach(context: Context) {
        super.onAttach(context)
        lifecycle.addObserver(this)
    }

    override fun onDetach() {
        super.onDetach()
        lifecycle.removeObserver(this)
    }
}