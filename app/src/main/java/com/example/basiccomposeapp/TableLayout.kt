package com.example.basiccomposeapp


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi


@ExperimentalPagerApi
@Composable
fun TableLayout(navController: NavController){

    var tabIndex by remember {
        mutableStateOf(0)
    }

    val tabs = listOf("Basic","Medium","Hard")

    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(selectedTabIndex = tabIndex) {
            tabs.forEachIndexed{ index,title ->
                Tab(text = { Text(title) },
                    selected = tabIndex == index,
                    onClick = {
                        tabIndex = index
                    when(index){
                        0-> navController.navigate(Destinations.Cards)
                        1-> navController.navigate(Destinations.Medium)
                        2->navController.navigate(Destinations.Hard)
                    }

                    }
                )
            }
        }

    }

}