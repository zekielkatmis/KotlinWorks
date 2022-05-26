package com.example.kotlincountries.service

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.kotlincountries.model.Country

@Dao
interface CountryDAO {
    //Data Access Object

    @Insert
    suspend fun insertAll(vararg countries: Country): List<Long>
    // ↑↑↑ INSERT INTO tabloAdı VALUES.... ↑↑↑

    //suspend -> durup başlayabilen fonksiyon. thread bloklamaz
    //vararg -> gelecek verinin miktarı bilinmediği için
    //          (ne kadar gelirse o kadar insert edilecek)
    //List<long> -> primary keys

    @Query("SELECT * FROM country")
    suspend fun getAllCountries(): List<Country>

    @Query("SELECT * FROM country WHERE uuid = :countryId")
    suspend fun getCountry(countryId: Int): Country

    @Query("DELETE FROM country")
    suspend fun deleteAllCountries()
}