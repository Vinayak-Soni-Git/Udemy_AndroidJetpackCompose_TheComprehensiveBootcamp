package com.example.kotlin.Fundamentals.Collections

fun main() {
    val names = listOf("James", "Paul", "Rafael", "Gina")
    val mutableNumbers = mutableListOf(12, 34, 45, 24)

    print(names)
    for (item in names) {
        println(item)
    }
    names.forEach { it: String ->
        println(it)
    }

    mutableNumbers.add(2)
    mutableNumbers.remove(12)
    mutableNumbers.removeAt(0)

    // Invoking methods on lists
    println(mutableNumbers.size)
    println("${mutableNumbers.get(1)}, ${mutableNumbers[1]}")
    println(mutableNumbers.indexOf(45))

    // Kotlin Sets and Maps collections
    val countrySet = setOf("Us", "Mz", "Au")
    println(countrySet)
    val mutableCountrySet = mutableSetOf(countrySet.toString())
    mutableCountrySet.add("In")
    println(mutableCountrySet)

    val secretMap = mapOf("up" to 1, "down" to 2, "left" to 3, "right" to 4)
    val mutableMap = mutableMapOf("up" to 1, "down" to 2, "left" to 3, "right" to 4)
    println(secretMap.keys)
    println(secretMap.entries)
    println(secretMap.values)

    println(mutableMap["Five"] to 5)

    if ("up" in secretMap) println("Yes") else println("No")

    //Initializing lists
    val mutableList = mutableListOf<String>()
    mutableList.add("Hello")
    mutableList.add("everyone")

    for (i in 0..10)
        mutableList.add(i.toString())

    // Empty Collections
    val emptyList = emptyList<String>()
    val emptySet = emptySet<Int>()
    val emptyMap = emptyMap<String, Int>()

    // Collection Filters
    val namesList = listOf("James", "Paul", "Rafael", "Gina")
    val filteredNames = namesList.filter{
        it.length > 4
    }


}