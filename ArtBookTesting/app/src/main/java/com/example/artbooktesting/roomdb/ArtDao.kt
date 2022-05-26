package com.example.artbooktesting.roomdb

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ArtDao {

    //Insert ederken herhangi bir id çakışmasında napılacağını belirtiyoruz

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArt(art: Art)

    @Delete
    suspend fun deleteArt(art: Art)

    @Query("SELECT * FROM arts")
    fun observeArts(): LiveData<List<Art>>
}