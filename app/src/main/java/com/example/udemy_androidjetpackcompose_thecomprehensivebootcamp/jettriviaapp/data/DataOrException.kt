package com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.jettriviaapp.data

data class DataOrException<T, Boolean, E:Exception>(
    var data:T? = null,
    var loading:Boolean? = null,
    var e:E? = null
)
