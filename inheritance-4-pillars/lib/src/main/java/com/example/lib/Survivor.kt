package com.example.lib

/*
-  name, health

-  fightZombies()
 */

open class Survivor (public val name: String) {
    var health: Int = 100

    open fun fight() {
        health--;
        println("$name is fighting!!!")
    }

    override fun toString(): String {
        return "Survivor(name='$name', health=$health)"
    }


}