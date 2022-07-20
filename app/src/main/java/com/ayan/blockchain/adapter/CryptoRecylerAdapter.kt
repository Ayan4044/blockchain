package com.ayan.blockchain.adapter

import android.content.Context


import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ayan.blockchain.R
import com.ayan.blockchain.model.DataClassCrypto
import com.google.android.material.button.MaterialButton
import java.lang.NullPointerException

class CryptoRecylerAdapter(val context: Context, val cryptolist: ArrayList<DataClassCrypto>) : RecyclerView.Adapter<CryptoRecylerAdapter.CryptoViewholder>() {



    class CryptoViewholder(inflate: View):  RecyclerView.ViewHolder(inflate) {
        var  imageView: ImageView = inflate.findViewById(R.id.imageViewcoin)

        var  textViewcoinname: TextView = inflate.findViewById(R.id.textViewcoinname)

        var textViewprice: TextView = inflate.findViewById(R.id.textViewprice)

        var textViewchange: TextView =  inflate.findViewById(R.id.textViewchange)

        var textViewpriceflow: TextView = inflate.findViewById(R.id.textViewpriceflow)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewholder  = CryptoViewholder(
        LayoutInflater.from(parent.context).inflate(R.layout.crypto_card_zones,parent,false))

    override fun onBindViewHolder(holder: CryptoViewholder, position: Int) {
        val cryptomodel = cryptolist[position]

        holder.textViewcoinname.text = cryptomodel.symbol
        holder.textViewprice.text = cryptomodel.volume
        holder.textViewchange.text = cryptomodel.highPrice
        holder.textViewpriceflow.text = cryptomodel.priceChangePercent

        try{
            if(cryptomodel.priceChangePercent != null){
        if(  cryptomodel.priceChangePercent!!.toFloat() < 0.0) {
            holder.textViewpriceflow.setTextColor(context.resources.getColor(R.color.red))
            holder. textViewpriceflow.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_downward

                , 0, 0, 0);
        }
        else
            holder.textViewpriceflow.setTextColor(context.resources.getColor(R.color.lightgreen))
            }

        }
        catch (ex: NullPointerException){
            println("ex $ex")
            holder.textViewpriceflow.text = cryptomodel.priceChangePercent
        }

        when(cryptomodel.symbol){
            "BCCBTC" ->{
                holder.imageView.setImageResource(R.drawable.ic_bitcoin)
            }
            "ETHBTC" -> {
                holder.imageView.setImageResource(R.drawable.ic_eth)
            }
            else -> {
                holder.imageView.setImageResource(R.drawable.ic_crypto)
            }
        }
    }

    override fun getItemCount(): Int = cryptolist.size

}