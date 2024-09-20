package com.example.movies.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movies.MovieRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(title =
            { Text(text = "hello") }
                , colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary
                    , titleContentColor = Color.White)
            )
        }
    ) {innerpadding->
        Column(modifier = Modifier.padding((innerpadding))) {
            MainContent(navcontroller = navController)
        }
    }
}


@Composable
fun MainContent(navcontroller:NavController
                ,moveList:List<String> = listOf(
        "3 Idiots",
        "Chhichhore",
        "Stree",
        "Dhamaal",
        "Spiderman Noway home",
        "Munna Bhai M.B.B.S",
        "Ghajini",
        "PK",
        "Hera Pheri",
        "Drishyam",
        "Avatar"
    ))
{
    Column( modifier = Modifier.padding(12.dp)) {
        //creating a recycler view
        LazyColumn{
            items(items =  moveList)
            {
                MovieRow(it){movie->
                    Log.d("TAG", "MainContent: $movie")
                }
            }
        }
    }
}