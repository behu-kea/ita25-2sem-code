package com.example.lib

class Lol(val price: Int): Comparable<Lol> {
    override fun compareTo(other: Lol): Int {
        return price - other.price
    }

    override fun toString(): String {
        return "Lol(price=$price)"
    }
}

interface Shape {
    val positionX: Int
    val positionY: Int

    fun move(): Boolean
    fun goHere(newPositionX: Int, newPositionY: Int)
    fun doesCollide(): Boolean
}

class Rectangle(override val positionX: Int, override val positionY: Int) : Shape {
    override fun move(): Boolean {
        TODO("Not yet implemented")
    }

    override fun goHere(newPositionX: Int, newPositionY: Int) {
        TODO("Not yet implemented")
    }

    override fun doesCollide(): Boolean {
        TODO("Not yet implemented")
    }
}

fun main() {
    val dictionary: MutableMap<String, String> = mutableMapOf()
    dictionary.set("træ", "et træ er en organisk...");
}




