package com.example.basiccomposeapp


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi




@ExperimentalPagerApi
@Composable
fun TableLayout(navController: NavController) {
    var tabIndex by remember { mutableStateOf(0) }

    val tabs = listOf("Basic", "Medium", "Hard")

    Column(modifier = Modifier
        .width(100.dp)
        .height(140.dp)
        .background(Color(153, 50, 204))
        .padding(start = 8.dp),
    ) {
        tabs.forEachIndexed { index, title ->
            Tab(
                text = { Text(title, color = Color.White, textAlign = TextAlign.Start) },
                selected = tabIndex == index,
                onClick = {
                    tabIndex = index
                    when (tabIndex) {
                        0 -> navController.navigate(Destinations.Basic)
                        1 -> navController.navigate(Destinations.Medium)
                        2 -> navController.navigate(Destinations.Hard)
                    }
                },
            )
        }
    }
}