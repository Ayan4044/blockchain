package com.ayan.blockchain.model

import com.google.gson.annotations.SerializedName

data class DataClassCrypto(
    @SerializedName("symbol") var symbol: String? = null,
    @SerializedName("priceChange") var priceChange: String? = null,
    @SerializedName("priceChangePercent") var priceChangePercent: String? = null,
    @SerializedName("weightedAvgPrice") var weightedAvgPrice: String? = null,
    @SerializedName("prevClosePrice") var prevClosePrice: String? = null,
    @SerializedName("lastPrice") var lastPrice: String? = null,
    @SerializedName("lastQty") var lastQty: String? = null,
    @SerializedName("bidPrice") var bidPrice: String? = null,
    @SerializedName("bidQty") var bidQty: String? = null,
    @SerializedName("askPrice") var askPrice: String? = null,
    @SerializedName("askQty") var askQty: String? = null,
    @SerializedName("openPrice") var openPrice: String? = null,
    @SerializedName("highPrice") var highPrice: String? = null,
    @SerializedName("lowPrice") var lowPrice: String? = null,
    @SerializedName("volume") var volume: String? = null,
    @SerializedName("quoteVolume") var quoteVolume: String? = null,
    @SerializedName("openTime") var openTime: String? = null,
    @SerializedName("closeTime") var closeTime: String? = null,
    @SerializedName("firstId") var firstId: String? = null,
    @SerializedName("lastId") var lastId: String? = null,
    @SerializedName("count") var count: String? = null
)
