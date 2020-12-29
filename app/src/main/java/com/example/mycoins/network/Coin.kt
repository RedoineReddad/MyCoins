package com.example.mycoins.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Coin(
        @Json(name="id")val id : String,
        @Json(name="symbol")val symbol : String,
        @Json(name="name")val name : String,
        @Json(name="image")val image : String,
        @Json(name="current_price")val current_price : Int,
        @Json(name="market_cap")val market_cap : Int,
        @Json(name="market_cap_rank")val market_cap_rank : Int,
        @Json(name="price_change_percentage_24h")val price_change_percentage_24h : Int,
        @Json(name="last_updated")val last_updated : String
) : Parcelable