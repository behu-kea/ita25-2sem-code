package com.example.lib

class TheGuyWhoAlwaysDiesFirst(name: String): Survivor(name) {
    private var tripChance: Int = 100;

    fun sayLastWords() {
        println(
            "I have seen this moment in every possible future. " +
                    "In none of them do I survive. " +
                    "Go. Learn. Win. " +
                    "I will buy you the seconds you need."
        )
    }

    override fun fight() {
        health -= 50
        println("i am fighting. Or at least i think i am")
    }
}