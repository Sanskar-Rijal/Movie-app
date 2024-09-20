package com.example.movies

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movies.navigation.MovieNavigation
import com.example.movies.ui.theme.MoviesTheme
import org.intellij.lang.annotations.PrintFormat

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




@Composable
@Preview
fun MovieRow(movie:String="sanskar",onItemClick:(String)->Unit={})
//onItemClick is of type string and it returns nothing , if we give = {} then
//we are saying at default we are not passing any thing
{
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(4.dp)
        .height(130.dp)
        .clickable {
            onItemClick(movie)
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
            Text(text = movie)
        }
    }
}