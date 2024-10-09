package com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.ui.theme.Udemy_AndroidJetpackCompose_TheComprehensiveBootcampTheme

class MainMovieAppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieApp {
                MainMovieAppContent()
            }
        }
    }
}

@Composable
fun MovieApp(content:@Composable () -> Unit){
    Udemy_AndroidJetpackCompose_TheComprehensiveBootcampTheme {
        content()
    }
}

@Composable
fun MainMovieAppContent(){
    Text(text = "Hello")
}

@Preview(showBackground = true)
@Composable
fun MovieAppPreview(){
    MovieApp {
        MainMovieAppContent()
    }
}
