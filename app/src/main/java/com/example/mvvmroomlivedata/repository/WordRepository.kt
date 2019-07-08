package com.example.mvvmroomlivedata.repository

import android.app.Application
import com.example.mvvmroomlivedata.model.Word
import com.example.mvvmroomlivedata.room.WordRoomDatabase
import org.jetbrains.anko.doAsync

class WordRepository(application: Application) {

    private val wordRoomDatabase =
            WordRoomDatabase.getDatabase(application) ?: throw IllegalStateException()
    private var wordDao = wordRoomDatabase.wordDao()

    fun getAll() = wordDao.getAll()

    fun insert(word: Word) {
        doAsync { wordDao.insert(word) }
    }
}