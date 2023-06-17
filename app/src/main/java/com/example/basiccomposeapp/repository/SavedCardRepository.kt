package com.example.basiccomposeapp.repository

import com.example.basiccomposeapp.db.SavedCard
import com.example.basiccomposeapp.db.SavedCardDao
import kotlinx.coroutines.flow.Flow

class SavedCardRepository(private val savedCardDao: SavedCardDao) {

    val savedCards : Flow<List<SavedCard>> = savedCardDao.getAllSavedCards()

    //Insert
    suspend fun saveCard(savedCard: SavedCard){
        savedCardDao.insert(savedCard)
    }

    //delete
    suspend fun deleteCard(savedCard: SavedCard){
        savedCardDao.deleteCard(savedCard)
    }
}