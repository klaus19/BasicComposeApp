package com.example.basiccomposeapp

import android.annotation.SuppressLint
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.basiccomposeapp.Destinations.ScreenA
import com.example.basiccomposeapp.Destinations.ScreenB
import com.example.basiccomposeapp.Destinations.ScreenC
import com.example.basiccomposeapp.db.SavedCard
import com.medium.viewpager.Cards


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun App() {

    val context = LocalContext.current
    val navController = rememberNavController()
    val items = listOf<String>("User","Play","Cards")
    val selectedItem = remember {
        mutableStateOf(0)
    }
    val savedCards = remember { mutableStateListOf<SavedCard>() }



    Scaffold(bottomBar = {
        BottomNavigation {
            items.forEachIndexed { index, item ->
                BottomNavigationItem(selected = selectedItem.value == index,
                    onClick = {
                        selectedItem.value = index
                        when(index){
                            0->navController.navigate(Destinations.ScreenA)
                            1->navController.navigate(Destinations.ScreenPlay)
                            2->navController.navigate(Destinations.Cards)
                        }
                              },
                    icon = {
                        if (index==0){
                            Icon(Icons.Default.Person, contentDescription = item)

                        }else{
                            Icon(Icons.Default.PlayArrow, contentDescription = item)
                        }
                         },
                    label = { Text(text = item) }
                )

            }

        }
    }
    ) {
        NavHost(navController = navController, startDestination = Destinations.ScreenA) {



            composable(ScreenA) {
                ScreenA(navController)
            }
            composable(ScreenB) {
                ScreenB(navController)
            }
            composable(ScreenC) {
                ScreenC(navController)
            }

            composable(Destinations.ScreenPlay){
                ScreenPlay(navController)
            }
            composable(Destinations.ScreenLearn){
                ScreenLearn(savedCards = savedCards)
            }
            composable(Destinations.Cards){
                Cards(navController)
            }
        }
    }
}

