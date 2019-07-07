package com.example.mvvmroomlivedata

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WordDAO {
    @Insert
    fun insert(word: Word)

    @Query("DELETE FROM words")
    fun deleteAll()

    @Query("SELECT * FROM words ORDER BY word ASC")
    fun getAll(): LiveData<List<Word>>
}