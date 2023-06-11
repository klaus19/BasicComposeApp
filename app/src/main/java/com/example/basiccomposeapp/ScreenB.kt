package com.example.basiccomposeapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun ScreenB(){

    val viewModel:Counterviewmodel = viewModel()
    
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Counter: ${viewModel.counter}")
        
        Button(onClick = { viewModel.increment() },) {
            Text(text = "Increment")
        }

        Button(onClick = { viewModel.decrement() }) {
            Text(text = "Decrement")
        }
    }

}