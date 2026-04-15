package com.example.unscramble.ui

import androidx.room.Dao

@Dao
interface WordDataDao {
    @insert
    fun insert()
}