package com.example.mycoins.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mycoins.database.Coins.CoinData
import com.example.mycoins.database.Users.User

@Dao
interface CoinDatabaseDao{

    @Insert
    fun insertUser(user : User)

    @Insert
    fun insertCoin(coin : CoinData)

    @Query("SELECT * FROM coin_data_table ORDER BY market_cap_rank DESC")
    fun getAllCoins(): LiveData<List<CoinData>>

    @Query("SELECT * FROM user_data_table WHERE email = :email AND password = :password")
    fun getUser(email: String, password: String) : User?
}