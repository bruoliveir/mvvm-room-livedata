package com.example.mvvmroomlivedata

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Word::class], version = 1)
abstract class WordRoomDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDAO

    companion object {
        @Volatile
        private var instance: WordRoomDatabase? = null

        fun getDatabase(context: Context): WordRoomDatabase? {
            if (instance == null) {
                synchronized(WordRoomDatabase::class) {
                    if (instance == null) {
                        instance = Room.databaseBuilder(context, WordRoomDatabase::class.java, "database").build()
                    }
                }
            }
            return instance
        }
    }
}