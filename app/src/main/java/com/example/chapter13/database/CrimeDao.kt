package com.example.chapter13.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.example.chapter13.Crime
import kotlinx.coroutines.flow.Flow
import java.util.UUID

@Dao
interface CrimeDao {

    @Query("Select * From crime")
    // suspend fun getCrimes(): List<Crime>
    fun getCrimes(): Flow<List<Crime>>

    @Query("Select * From crime Where id=(:id)")
    suspend fun getCrime(id:UUID):Crime

    @Update
    suspend fun updateCrime(crime: Crime)
}