package com.example.lib

/*
-  bravery
-  motivateTeam()
 */

class Leader(name: String): Survivor(name) {
    private var bravery: Int = 100

    fun motivatTeam() {
        println("Lets go guys and girls")
    }

    override fun fight() {
        bravery -= 2;
        println("We can do this!")
    }

    override fun toString(): String {
        return "Leader(bravery=$bravery)"
    }
}