package com.example.unscramble.data
import android.content.Context
import kotlinx.coroutines.flow.Flow

class WordRepository(private val wordDao: WordDao) {
    val allWords: Flow<List<WordEntity>> = wordDao.getAllNewWord()

    suspend fun insert(word: WordEntity) {
        wordDao.insert(word)
    }
}
