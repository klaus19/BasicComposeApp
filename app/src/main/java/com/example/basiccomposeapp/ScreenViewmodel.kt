package com.example.basiccomposeapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basiccomposeapp.db.SavedCard
import com.example.basiccomposeapp.repository.SavedCardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ScreenViewModel(private val savedCardRepository:SavedCardRepository):ViewModel() {


    val savedCards: Flow<List<SavedCard>> = savedCardRepository.savedCards

    fun insert(savedCard: SavedCard) {
        viewModelScope.launch {
            savedCardRepository.saveCard(savedCard)
        }
    }

    fun delete(savedCard: SavedCard) {
        viewModelScope.launch {
            savedCardRepository.deleteCard(savedCard)
        }
    }



}