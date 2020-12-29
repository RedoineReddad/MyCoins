package com.example.mycoins.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mycoins.network.Coin
import com.example.mycoins.network.CoinGeckoAPIStatus
import com.example.mycoins.network.CoinsApi
import kotlinx.coroutines.*

class OverviewViewModel: ViewModel() {

//    private val _response = MutableLiveData<String>()
//    val response : LiveData<String>
//        get() = _response

    private val _status = MutableLiveData<CoinGeckoAPIStatus>()
    val status : LiveData<CoinGeckoAPIStatus>
        get() = _status

    private val _coins = MutableLiveData<List<Coin>>()
    val coins : LiveData<List<Coin>>
        get() = _coins

    private val viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)
    init{
        getCoinsData()
    }

    private fun getCoinsData() {
        var getCoinsDeferred = CoinsApi.retrofitService.getAllCoins(
            vs_currency = "usd",
            order = "market_cap_desc",
            per_page = "100",
            page = "1",
            sparkline = "false"
        )
        coroutineScope.launch {
            try {
                _status.value = CoinGeckoAPIStatus.LOADING
                var response = getCoinsDeferred.await()
                if(response.isNotEmpty()){
                    _coins.value = response
                    _status.value = CoinGeckoAPIStatus.DONE
                }
            } catch (t: Throwable){
                _status.value = CoinGeckoAPIStatus.ERROR
            }
        }
    }
}