package com.example.unscramble.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database([WordEntity::class], version = 1)
abstract class WordDatabase: RoomDatabase() {
    abstract fun WordDao(): WordDao

    companion object {
        @Volatile
        private var INSTANCE: WordDatabase ?= null

        fun getInstance(context: Context): WordDatabase{
            return INSTANCE ?: synchronized(this){
                INSTANCE ?: Room.databaseBuilder(context.applicationContext,WordDatabase::class.java, "word_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}