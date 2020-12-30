package com.example.mycoins.database.Coins

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coin_data_table")
data class CoinData (
        @PrimaryKey(autoGenerate = false)
        val id : String,

        @ColumnInfo(name = "symbol")
        val symbol : String,
        @ColumnInfo(name = "name")
        val name : String,
        @ColumnInfo(name = "image")
        val image : String,
        @ColumnInfo(name = "current_price")
        val current_price : Int,
        @ColumnInfo(name = "market_cap")
        val market_cap : Int,
        @ColumnInfo(name = "market_cap_rank")
        val market_cap_rank : Int,
        @ColumnInfo(name = "price_change_percentage_24h")
        val price_change_percentage_24h : Int,
        @ColumnInfo(name = "last_updated")
        val last_updated : String
)