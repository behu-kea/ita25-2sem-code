package com.example.lib

import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.sqrt

fun main() {
    var age: Int
    //println("asd")
    val name = "benjamin"
    val secondCharacterInBenjamin: Char = name.get(0)


    val numbers: List<Int> = listOf(1, 2, 3, 4, 5);
    val transformedList = getTransformList(numbers)
    //println(transformedList)
    for (i in 1..5) {
        if (i == 3) break
        //println(i)
    }

    opgave2()

    opgave7()
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


fun opgave2() {
    val name: String = "benjamin"
    val nameUppercase = name.uppercase()
    println(nameUppercase)
    val characterOnIndex3:Char = nameUppercase.get(3)
    println(characterOnIndex3)
    println("hej " + " hej igen")
    val string1 = "name"
    val string2 =  "NaMe"

    println(string1.equals(string2, ignoreCase = true))
}


fun opgave7() {
    for (i in 1..100) {
        println(i)
        val isEven = i % 2 == 0
        val squareRoot = sqrt(i.toDouble())
        val isPerfect = ceil(squareRoot/3) == floor(squareRoot/3)
        if(isEven && isPerfect) {
            println(i)
        }
        println(isPerfect)

    }
}