package com.example.movies.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movies.model.Movie
import com.example.movies.model.getmovies

@Preview
@Composable
fun MovieRow(movie: Movie= getmovies()[0], onItemClick:(String)->Unit={})
//onItemClick is of type string and it returns nothing , if we give = {} then
//we are saying at default we are not passing any thing
{
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)
        .height(130.dp)
        .clickable {
            onItemClick(movie.id)
        }
        , elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
        ,shape = RoundedCornerShape(corner = CornerSize(15.dp)
        )
    ) {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start) {
            Surface(modifier = Modifier
                .padding(12.dp)
                .size(100.dp)
                , shape = RectangleShape
                , shadowElevation = 10.dp
            ) {
                Icon(imageVector = Icons.Default.AccountBox,
                    contentDescription ="Image",
                )
            }
            Column(modifier = Modifier.padding(4.dp)) {
                Text(text = movie.title,
                    style = MaterialTheme.typography.titleMedium)
                Text(text = "Director: ${movie.title}"
                , style = MaterialTheme.typography.bodyMedium
                )
                Text(text = "Released: ${movie.year}")
            }
        }
    }
}