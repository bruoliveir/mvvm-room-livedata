package com.example.mvvmroomlivedata

import android.app.Application
import org.jetbrains.anko.doAsync

class WordRepository(application: Application) {

    private val wordRoomDatabase = WordRoomDatabase.getDatabase(application) ?: throw IllegalStateException()
    private var wordDao = wordRoomDatabase.wordDao()

    fun getAll() {
        wordDao.getAll()
    }

    fun insert(word: Word) {
        doAsync { wordDao.insert(word) }
    }

    fun deleteAll() {
        doAsync { wordDao.deleteAll() }
    }
}