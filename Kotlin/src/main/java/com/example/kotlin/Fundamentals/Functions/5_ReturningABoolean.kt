package com.example.kotlin.Fundamentals.Functions

fun main(){
    val catAge = calculateCatAge(age = 12)
    print(checkAge(catAge))
}

fun checkAge(catAge:Int):Boolean{
    return catAge > 14
}