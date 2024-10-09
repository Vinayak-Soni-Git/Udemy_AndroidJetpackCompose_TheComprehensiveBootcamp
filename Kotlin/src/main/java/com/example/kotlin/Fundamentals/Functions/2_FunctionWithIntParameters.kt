package com.example.kotlin.Fundamentals.Functions

fun main(){
    calculate(1, 100, 2)
}

fun calculate(first:Int, second:Int, multipleOf:Int){
    for(i in first..second){
        if(i%multipleOf==0){
            println("$i is multiple of $multipleOf")
        }
    }
}