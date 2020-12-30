package com.example.mycoins.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mycoins.database.Coins.CoinData
import com.example.mycoins.database.Users.User


@Database(entities = [CoinData::class, User::class], version = 1, exportSchema = false)
abstract class CoinsDatabase : RoomDatabase() {

    /**
     * Connects the db to the DAO
     */
    abstract val coinDatabaseDao : CoinDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE : CoinsDatabase? = null

        fun getInstance(context: Context): CoinsDatabase {

            synchronized(this){
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CoinsDatabase::class.java,
                        "my_coins_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    // Assign INSTANCE to the newly created database.
                    INSTANCE = instance
                }
                // Return instance; smart cast to be non-null.
                return instance
            }
        }
    }
}