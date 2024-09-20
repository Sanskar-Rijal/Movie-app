package com.example.movies.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MovieNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController
        , startDestination = MovieScreen.HomeScreen.name ){
        composable(MovieScreen.HomeScreen.name){
            //here we pass where  this should lead us to  , we want to go to homescreen
            //HomeScreen()
        }
    }
}