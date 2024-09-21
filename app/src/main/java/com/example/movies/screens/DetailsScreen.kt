package com.example.movies.screens

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import coil.compose.rememberImagePainter
import com.example.movies.R
import com.example.movies.model.getmovies
import com.example.movies.widgets.MovieRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(navController: NavController,
                  movieId: String?)
{
    //finding a movie with movieId
    val moviethatmatchid = getmovies().filter { movie->
        movie.id == movieId
    }
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
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top) {
                MovieRow(movie=moviethatmatchid.first())

                //making a scrollable row , for vertical scrollable we use lazycolumn, for horizontal we use lazy row
                Spacer(modifier = Modifier.height(8.dp))
                Divider(thickness = 1.dp, color = Color.LightGray)

                Text(text = "MOVIE IMAGES"
                , style = MaterialTheme.typography.titleMedium
                , fontWeight = FontWeight.Bold)

                LazyRow {
                    items(moviethatmatchid.first().images){image->
                        Card(modifier= Modifier
                            .padding(12.dp)
                            .size(height = 240.dp, width = 300.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)){
                            //Image(painter = rememberImagePainter(data = image), contentDescription = "images")
//                            AsyncImage(model = image,
//                                placeholder = painterResource(R.drawable.dummy),
//                                contentDescription = "images")
                            SubcomposeAsyncImage(model = image,
                                contentScale = ContentScale.FillBounds,
                            contentDescription = "images"){
                                val state =painter.state
                                if(state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error){
                                    CircularProgressIndicator()
                                }
                                else{
                                    SubcomposeAsyncImageContent()
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}