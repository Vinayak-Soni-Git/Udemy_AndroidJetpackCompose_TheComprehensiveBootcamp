package com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.jettriviaapp.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.jettriviaapp.components.Questions

@Composable
fun TriviaHome(viewModel: QuestionsViewModel = hiltViewModel()){
    Questions(viewModel)
}