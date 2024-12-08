package com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.jettriviaapp.model

data class QuestionItem(
    val answer: String,
    val category: String,
    val choices: List<String>,
    val question: String
)