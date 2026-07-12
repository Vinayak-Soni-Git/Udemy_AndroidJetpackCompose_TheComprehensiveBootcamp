package com.example.kotlin.Fundamentals.ObjectOrientedProgrammingConcept

fun main() {
    val car = Car(color = "Green", model = "LLM")
    val anotherCar = Car(color = "grey", model = "Saracen")
    println(car.color)
    car.color = "White"
    println(car.color)

    val truck = Truck(color = "Magenta", model = "F6")
    truck.drive()

    val button = Button(label = "Press")
    button.onClick("You pressed me!")

    println("Hello Jenny ".append("Welcome"))
    println("Hello".removeFirstAndLast())

    val person = Person(name = "Joe", lastName = "Ball", age = 24)
    println(person)
}

open class Car(var color: String, var model: String) {
//    var color: String = "Red"
//    val model: String = "XMD"

    init {
        color = "White"
        model = "Crete"
    }

    open fun speed(minSpeed: Int, maxSpeed: Int) {

    }

    open fun drive() {
        println("Driving...")
    }
}

class Truck(color: String, model: String) : Car(color, model) {
    override fun drive() {
        println("Driving the truck")
    }

    override fun speed(minSpeed: Int, maxSpeed: Int) {
        super.speed(minSpeed, maxSpeed)
        val fullSpeed = minSpeed * maxSpeed
        println(fullSpeed)
    }
}

class Button(val label: String) : ClickEvent {
    override fun onClick(message: String) {
        println("clicked by $label button for message $message")
    }
}

interface ClickEvent {
    fun onClick(message: String)
}

fun String.append(toAppend: String): String {
    return this.plus(toAppend)
}

fun String.removeFirstAndLast(): String {
    return this.substring(1, this.length - 1)
}

data class Person(val name: String, val lastName: String, val age: Int)