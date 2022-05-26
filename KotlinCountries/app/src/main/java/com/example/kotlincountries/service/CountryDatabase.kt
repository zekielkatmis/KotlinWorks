package com.example.kotlincountries.service

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kotlincountries.model.Country

@Database(entities = [Country::class], version = 1)
abstract class CountryDatabase : RoomDatabase() {
    abstract fun countryDao(): CountryDAO

    //Bu sınıf dışında her yerden ulaşmamızı sağlayacak
    companion object {
        @Volatile
        private var instance: CountryDatabase? = null
        //Volatile diğer threadlere de görünür hale gelecek

        private val lock = Any()

        //Aynı anda tek bir threadten işlem yapılabilecek
        operator fun invoke(context: Context) = instance ?: synchronized(lock) {
            instance ?: makeDatabase(context).also {
                instance = it
            }
        }

        private fun makeDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext, CountryDatabase::class.java, "country-database"
        ).build()
        //applicationContext: contexti app'in kendisinden alıyor.
        //ekranı yan çevirme gibi context yıkımlarından etkilenmemiş olacak
    }
}