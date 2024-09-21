package com.example.movies.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(navController: NavController,
                  moviename: String?)
{
    Scaffold(topBar = {
        TopAppBar(title ={
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(text = "Details")
            } }
            , colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primary
                , titleContentColor = Color.White), navigationIcon ={
                    Row(modifier = Modifier.padding(10.dp),
                        horizontalArrangement =Arrangement.Start) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "arrow to go back"
                            //adding modifer to make it clickable
                            , modifier = Modifier.clickable {
                                navController.popBackStack()
                            })
//                        Text(text ="Movies")
                    }
            }
        )}){innerpadding->
        Surface(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(innerpadding)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                Text(text = moviename.toString(), style = MaterialTheme.typography.displaySmall)
            }
        }
    }

}