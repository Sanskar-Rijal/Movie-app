package com.example.movies.navigation

import android.app.FragmentManager.BackStackEntry
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movies.screens.DetailsScreen
import com.example.movies.screens.HomeScreen

@Composable
fun MovieNavigation(){
    val navController = rememberNavController()

     NavHost(navController = navController
        , startDestination = MovieScreen.HomeScreen.name ){

        composable(MovieScreen.HomeScreen.name){

            //here we pass where  this should lead us to  , we want to go to homescreen
            HomeScreen(navController)//we start from home screen at first and go towards next screens

        }
//www.google.com/detailsscreen
         //now we want to pass /id=34 , sth like that such that it becomes
         //www.google.com/detailscreen/id=34
        composable(MovieScreen.DetailsScreen.name+"/{movie}"
        , arguments = listOf(navArgument(name = "movie"){type= NavType.StringType})){
            BackStackEntry-> //variable that contains information that we want
            DetailsScreen(navController
                ,BackStackEntry.arguments?.getString("movie"))
        }
    }
}