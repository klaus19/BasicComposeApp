package com.example.basiccomposeapp.db

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

interface SavedCardDao {

    @Query("SELECT * FROM saved_cards")
    fun getAllSavedCards(): Flow<List<SavedCard>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(savedCard: SavedCard)

    @Delete
    suspend fun deleteCard(savedCard: SavedCard)

}