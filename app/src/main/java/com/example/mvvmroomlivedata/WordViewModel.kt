package com.example.mvvmroomlivedata

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class WordViewModel(application: Application) : AndroidViewModel(application) {
    private val wordRepository by lazy { WordRepository(application) }

    fun getAllWords() = wordRepository.getAll()

    fun insert(word: Word) {
        wordRepository.insert(word)
    }
}