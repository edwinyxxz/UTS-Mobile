package com.example.unscramble.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {
    @Query("SELECT * FROM word_table")
    fun getAllNewWord(): Flow<List<WordEntity>>
    @Insert(onConflict = OnConflictStrategy.Companion.IGNORE)
    suspend fun insert(word: WordEntity)
}