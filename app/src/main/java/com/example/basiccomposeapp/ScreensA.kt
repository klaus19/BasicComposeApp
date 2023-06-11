package com.example.basiccomposeapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun ScreenA(navController: NavController) {
    val gridItems = listOf("Card 1", "Card 2", "Card 3")

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(8.dp)
    ) {
        itemsIndexed(gridItems) { index,item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .height(50.dp)
                    .width(50.dp)
                    .clickable {
                        when (index) {
                            0 -> navController.navigate(Destinations.ScreenA)
                            1 -> navController.navigate(Destinations.ScreenB)
                            2 -> navController.navigate(Destinations.ScreenC)
                        }

                    }
            ,backgroundColor = Color.Blue,
            )
            {
                Text(text = item, color = Color.White, textAlign = TextAlign.Center, modifier = Modifier.fillMaxSize().padding(12.dp))
            }
        }
    }
}

