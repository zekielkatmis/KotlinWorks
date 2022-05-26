package com.example.kotlincountries.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Country(
    @ColumnInfo(name = "name") // hiçbir şey yazılmazsa countryName alır
    @SerializedName("name")
    val countryName: String?,

    @ColumnInfo(name = "region")
    @SerializedName("region")
    val countryRegion: String?,

    @ColumnInfo(name = "capital")
    @SerializedName("capital")
    val countryCapital: String?,

    @ColumnInfo(name = "currency")
    @SerializedName("currency")
    val countryCurrency: String?,

    @ColumnInfo(name = "flag")
    @SerializedName("flag")
    val countryUrl: String?,

    @ColumnInfo(name = "language")
    @SerializedName("language")
    val countryLanguage: String?
) {

    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0

}