package com.example.mycoins.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Coin(
        val id : String,
        val symbol : String,
        val name : String,
        val image : String,
        val current_price : Int,
        val market_cap : Int,
        val market_cap_rank : Int,
        val price_change_percentage_24h : Int,
        val last_updated : String
) : Parcelable