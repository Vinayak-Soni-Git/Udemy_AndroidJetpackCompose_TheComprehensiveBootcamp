package com.example.kotlin.Fundamentals.Functions

fun main() {
    add(5, 5)

    enhancedMessage(message = "Hello"){
        print(it)
        add(12, 12)
    }
}


val add: (Int, Int) -> Int = { a, b -> a + b }

val catAge: (Int) -> Int = { age -> age * 7 }

// Using "it" lambda keyword
val calcCatAge: (Int) -> Int = { it * 7 }

// Lambda expressions that returns Unit - void
val name: (String) -> Unit = { print(it) }

// Trailing Lambda
fun enhancedMessage(message:String, funAsParameter: (String)->Int){
    println("$message ${funAsParameter("Hey")}")
}

fun sum(a: Int, b: Int): Int {
    return a + b
}
