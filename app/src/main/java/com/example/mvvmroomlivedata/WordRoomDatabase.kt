package com.example.mvvmroomlivedata

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import org.jetbrains.anko.doAsync

@Database(entities = [Word::class], version = 1)
abstract class WordRoomDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDAO

    companion object {
        @Volatile
        private var instance: WordRoomDatabase? = null

        private val populateCallback by lazy {
            object : RoomDatabase.Callback() {
                override fun onOpen(db: SupportSQLiteDatabase) {
                    doAsync {
                        instance?.wordDao()?.run {
                            deleteAll()
                            insert(Word("Hello"))
                            insert(Word("World"))
                        }
                    }
                }
            }
        }

        fun getDatabase(context: Context): WordRoomDatabase? {
            if (instance == null) {
                synchronized(WordRoomDatabase::class) {
                    if (instance == null) {
                        instance = Room
                                .databaseBuilder(context, WordRoomDatabase::class.java, "database")
                                .addCallback(populateCallback)
                                .build()
                    }
                }
            }
            return instance
        }
    }
}