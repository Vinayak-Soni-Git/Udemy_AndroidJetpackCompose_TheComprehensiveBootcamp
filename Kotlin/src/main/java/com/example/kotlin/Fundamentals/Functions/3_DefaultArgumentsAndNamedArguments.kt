package com.example.kotlin.Fundamentals.Functions

fun main(){
    calculate2(message = "is multiple of", first = 1, second = 100, multipleOf = 2)
}

fun calculate2(first:Int = 1, second:Int = 1000, message:String, multipleOf:Int){
    for(i in first..second){
        if(i%multipleOf==0){
            println("$i $message $multipleOf")
        }
    }
}