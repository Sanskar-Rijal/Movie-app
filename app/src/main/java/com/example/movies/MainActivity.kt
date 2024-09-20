package com.example.movies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.movies.ui.theme.MoviesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
          myapp {
              MainContent()
          }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    myapp {
        MainContent()
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun myapp( content: @Composable ()-> Unit) {
    MoviesTheme {
        Scaffold(
            topBar = {
                TopAppBar(title =
                { Text(text = "hello welcome") }
                , colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary
                , titleContentColor = Color.White)
                    )
            }
        ) {innerpadding->
            Column(modifier = Modifier.padding((innerpadding))) {
                content()
            }

        }
    }
}


@Composable
fun MainContent()
{
    Surface(color = MaterialTheme.colorScheme.background

    ) {
        Text(text = "hello")
    }
}