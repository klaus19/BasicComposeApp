package com.example.basiccomposeapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class Counterviewmodel:ViewModel() {

    var counter by mutableStateOf(0)
        private set

    fun increment(){
        counter++
    }

    fun decrement(){
        if (counter>0){
            counter--
        }
    }
}