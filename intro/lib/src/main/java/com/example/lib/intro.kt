package com.example.lib

fun main() {
    println("asd")
    val numbers: List<Int> = listOf(1, 2, 3, 4, 5);
    val transformedList = getTransformList(numbers)
    println(transformedList)
    for (i in 1..5) {
        if (i == 3) break
        println(i)
    }
}

fun getTransformList(array: List<Int>): MutableList<Int> {
    val transformedArray: MutableList<Int> = mutableListOf()
    array.forEach ({ element ->
        val isEven = element % 2 == 0;
        if(isEven) {
            transformedArray.add(element / 2)
        } else {
            transformedArray.add((element * 3) + 1)
        }
    })

    return transformedArray
}

