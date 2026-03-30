package com.ying.cookly

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Recipe::class, ShoppingItem::class], version = 1)
abstract class CooklyDatabase : RoomDatabase() {
    abstract fun dao(): CooklyDao

    companion object {
        @Volatile
        private var INSTANCE: CooklyDatabase? = null

        fun getDatabase(context: Context): CooklyDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CooklyDatabase::class.java,
                    "cookly_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}