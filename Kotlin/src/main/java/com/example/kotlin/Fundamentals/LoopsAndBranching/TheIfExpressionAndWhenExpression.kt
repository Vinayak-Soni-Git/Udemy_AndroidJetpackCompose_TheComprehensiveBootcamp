package com.example.kotlin.Fundamentals.LoopsAndBranching

fun main(){
    val amount = 1200
    if(amount == 1000){
        print("You're wealthy")
    }
    else if(amount > 1000){
        print("You're very wealthy")
    }
    else{
        print("You are getting by")
    }
    
    when(amount){
        100 -> print("You have 100")
        125 -> print("You are getting there...")
        999 -> print("Really Close")
        1000 -> print("rich but not there")
        1100 -> print("You've made it")
        else ->{
            print("$amount is just not going to work ")
        }
    }

    when(amount){
        in 1..100 -> print("This amount is between 1 and 100")
        in 100..1000 -> print("This amount is between 100 and 1000")
        999 -> print("Really Close")
        1000 -> print("rich but not there")
        1100 -> print("You've made it")
        else ->{
            print("$amount is just not going to work ")
        }
    }
    
}