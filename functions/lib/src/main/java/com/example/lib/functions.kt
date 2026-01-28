package com.example.lib

fun main() {
    val numbers: List<Int> = listOf(1, 2, 3, 4, 5);

    val transformedListMap = getTransformListMap(numbers)
    println(transformedListMap)


    /*
    DET HER ER DET SAMME! Samme måde at lave funktioner på. Konceptuelt. Der er måske problemer med syntax
    fun greetFun(name) {
        return "Hello, $name!"
    }

    val greetLambda = { name -> "Hello, $name!" }
     */

    // Fra peer instruction
    fun greetFun(name:String): String {
        return "Hello, $name!"
    }

    val greetLambda: (String) -> String = { name -> "Hello, $name!" }

    println(greetLambda("Kotlin"))


    // Flere parametre
    val greet: (String, Int) -> String = { name, h -> "Hello, $name, $h!" }

    // Ingen parametre
    val greet1: () -> String = {  -> "Hello,!" }
    greet1()


    println(greet("Kotlin", 10))

    /*
    val numbers = listOf(1, 2, 3, 4)
    val doubled = numbers.map { it * 2 }
    Det her er det samme
    val doubled = numbers.map { element -> element * 2 }
    println(doubled)
     */
}

fun getTransformListMap(list: List<Int>): List<Int> {
    return list.map { element ->
        val isEven = element % 2 == 0
        if(isEven) {
            element / 2
        } else {
            (element * 3) + 1
        }
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



