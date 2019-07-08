package com.example.mvvmroomlivedata.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words")
data class Word(@PrimaryKey val word: String)