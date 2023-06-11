package com.example.basiccomposeapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.basiccomposeapp.Destinations.ScreenC


@Composable
fun App(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Destinations.ScreenA){

        composable(Destinations.ScreenA){
            ScreenA(navController)
        }
        composable(Destinations.ScreenB){
            ScreenB()
        }
        composable(ScreenC){
            ScreenC()
        }
    }


}