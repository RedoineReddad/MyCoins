package com.example.mycoins.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import kotlinx.coroutines.Deferred

private const val BASE_URL = "https://api.coingecko.com/api/v3/coins/markets"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()



interface CoinGeckoAPIService {
    @GET("")
    fun getAllCoins(
        @Query("vs_currency") vs_currency : String,
        @Query("order") order : String,
        @Query("per_page") per_page : String,
        @Query("page") page : String,
        @Query("sparkline") sparkline : String
    ) : Deferred<List<Coin>>
}

// Singleton object to initialize API service
object CoinsApi{
    val retrofitService : CoinGeckoAPIService by lazy { retrofit.create(CoinGeckoAPIService::class.java) }
}