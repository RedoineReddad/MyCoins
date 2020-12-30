package com.example.mycoins.database.Users

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user_data_table")
data class User (
        @PrimaryKey(autoGenerate = true)
        val id : Long = 0L,

        @ColumnInfo(name = "email")
        val email : String,

        @ColumnInfo(name = "password")
        val password : String
)