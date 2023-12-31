package com.example.basiccomposeapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.basiccomposeapp.db.SavedCard
import com.example.basiccomposeapp.repository.SavedCardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch

class ScreenViewModel(private val savedCardRepository:SavedCardRepository):ViewModel() {


    // Using LiveData and caching what allWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val allWords: LiveData<List<SavedCard>> = savedCardRepository.savedCards.asLiveData()




    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insertCards(savedCard: SavedCard) = viewModelScope.launch {
        savedCardRepository.saveCard(savedCard)
    }

    fun deleteCards(savedCard: SavedCard) = viewModelScope.launch {
        savedCardRepository.deleteCard(savedCard)
    }

}

class ScreenViewmodelFactory(private val savedCardRepository:SavedCardRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScreenViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ScreenViewModel(savedCardRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}