package com.example.movies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable

import androidx.compose.ui.tooling.preview.Preview
import com.example.movies.navigation.MovieNavigation
import com.example.movies.ui.theme.MoviesTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            myapp {
                MovieNavigation()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    myapp {
        MovieNavigation()
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun myapp( content: @Composable ()-> Unit) {
    MoviesTheme {

        content()
    }
}