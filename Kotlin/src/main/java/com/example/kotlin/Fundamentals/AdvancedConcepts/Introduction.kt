package com.example.kotlin.Fundamentals.AdvancedConcepts

fun main() {
    val listOfItem = listOf("Rafael", "Gina", "George", "James")
    val finder = Finder(list = listOfItem)
    finder.findItem(element = "Gina") {
        println("Found $it")
    }

    val input = Result.SUCCESS
    getResult(result = input)
}

class Finder<T>(private val list: List<T>) {
    fun findItem(element: T, foundItem: (element: T?) -> Unit) {
        val itemFoundList = list.filter {
            it == element
        }
        if (itemFoundList.isEmpty()) foundItem(null) else foundItem(itemFoundList.first())
    }
}

object Repository {
    private var loadState: Result = Result.IDLE
    private var dataFetched: String? = null
    fun startFetch() {
        loadState = Result.LOADING
        dataFetched = "data"
    }

    fun finishedFetch() {
        loadState = Result.SUCCESS
        dataFetched = null
    }

    fun error() {
        loadState = Result.ERROR
    }

    fun getCurrentState(): Result {
        return loadState
    }

}

fun getResult(result: Result) {
    return when (result) {
        Result.SUCCESS -> println("Success")
        Result.FAILURE -> println("Failure")
        Result.ERROR -> println("Error")
        Result.IDLE -> println("Idle")
        Result.LOADING -> println("Loading")
    }
}

enum class Result {
    SUCCESS, FAILURE, ERROR, IDLE, LOADING
}

abstract class Result2

data class Success(val dataFetched: String?) : Result2()
data class Error(val exception: Exception) : Result2()
object NotLoading : Result2()
object Loading : Result2()