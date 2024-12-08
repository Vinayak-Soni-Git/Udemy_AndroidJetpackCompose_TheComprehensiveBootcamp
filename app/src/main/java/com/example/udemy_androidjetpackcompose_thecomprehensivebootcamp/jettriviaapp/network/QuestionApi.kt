package com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.jettriviaapp.network

import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.jettriviaapp.model.Question
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface QuestionApi {
    @GET("world.json")
    suspend fun getAllQuestions():Question
}