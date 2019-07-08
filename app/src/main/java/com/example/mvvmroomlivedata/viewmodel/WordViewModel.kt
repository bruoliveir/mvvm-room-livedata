package com.example.mvvmroomlivedata.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.mvvmroomlivedata.model.Word
import com.example.mvvmroomlivedata.repository.WordRepository

class WordViewModel(application: Application) : AndroidViewModel(application) {
    private val wordRepository by lazy { WordRepository(application) }

    fun getAllWords() = wordRepository.getAll()

    fun insert(word: Word) {
        wordRepository.insert(word)
    }
}