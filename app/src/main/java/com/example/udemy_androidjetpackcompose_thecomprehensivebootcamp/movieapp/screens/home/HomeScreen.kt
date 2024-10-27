package com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.movieapp.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.movieapp.models.Movie
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.movieapp.models.getMovies
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.movieapp.navigation.MovieScreens
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.movieapp.widgets.MovieRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("My App", fontSize = 20.sp)
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Black, titleContentColor = Color.White)
            )
        },
        content = { innerPadding ->
            Column {
                Text(
                    text = "Hello, World!",
                    modifier = Modifier.padding(innerPadding)
                )
                MainMovieAppContent(navController = navController)
            }

        }
    )
}

@Composable
fun MainMovieAppContent(navController: NavController,
                        movieList:List<Movie> = getMovies()
){
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn {
            items(movieList){
                MovieRow(movie = it){movie->
                    navController.navigate(route = MovieScreens.DetailsScreen.name+"/$movie")
                }
            }
        }
    }
}