package com.example.chapter12.database

import androidx.room.Database
import com.example.chapter12.Crime

@Database(entities = [Crime::class], version = 1)
class CrimeDatabase {
}