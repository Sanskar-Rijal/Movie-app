package com.example.movies.navigation

import java.lang.IllegalArgumentException

//www.google.com/sign-in
//route==signin
enum class MovieScreen {
    HomeScreen,
    DetailsScreen;
    companion object{
        fun fromRoute(route:String?):MovieScreen
                = when(route?.substringBefore("/")){
            HomeScreen.name-> HomeScreen
            DetailsScreen.name->DetailsScreen
            null->HomeScreen //if it's null let's just go back to home screen
            else->throw IllegalArgumentException("Route $route is not recognised")
        }
    }
}