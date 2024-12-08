package com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.capstonereaderapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.capstonereaderapp.screens.ReaderSplashScreen
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.capstonereaderapp.screens.home.ReaderHomeScreen
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.capstonereaderapp.screens.login.ReaderLoginScreen
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.capstonereaderapp.screens.search.ReaderBookSearchScreen

@Composable
fun ReaderNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ReaderScreens.SplashScreen.name){
        composable(ReaderScreens.SplashScreen.name){
            ReaderSplashScreen(navController = navController)
        }
        composable(ReaderScreens.LoginScreen.name){
            ReaderLoginScreen(navController = navController)
        }
        composable(ReaderScreens.ReaderHomeScreen.name){
            ReaderHomeScreen(navController = navController)
        }
        composable(ReaderScreens.SearchScreen.name){
            ReaderBookSearchScreen(navController = navController)
        }
    }
}