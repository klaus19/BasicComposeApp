package com.example.basiccomposeapp.db

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [SavedCard::class], version = 1)
abstract class AppDatabase:RoomDatabase() {

    abstract fun savedCardDao(): SavedCardDao



}