package com.example.lib

class Student(var name: String, val initialMoney: Int, private val homeTown: String): Comparable<Student> {
    val officialName: String
        get() = "Sir $name"

    var money: Int = initialMoney
        set(value) {
            if (value >= 0) {
                field = value
            } else {
                field = 0
            }
        }

    fun addMoney(amount: Int) {
        money += amount
    }

    override fun compareTo(other: Student): Int {
        return other.name.length - name.length
    }

    override fun toString(): String {
        return "Student(name='$name', initialMoney=$initialMoney, officialName='$officialName', money=$money)"
    }
}

fun main() {
    val per: Student = Student("per", 100, "alabama");
    per.addMoney(100)

    // getter attributten name på per objektet
    println(per.name)
    // Setter
    per.name = "michael"
    println(per.name)

    println(per.officialName)

    per.money = -100
    println(per.money)

    val hanne: Student = Student("hanne", 1000, "cph");

    println(per.compareTo(hanne))

    val students: List<Student> = listOf(per, hanne);
    println(students.sorted())

    val dictionary: MutableMap<String, String> = mutableMapOf();
    dictionary.set("Træ", "Et træ er en organisk...")
    println(dictionary.get("Træ"))
}

fun checkNumber(number: Int): String {
    // Your code here
    return when {
        number > 0 -> "Positive"
        number < 0 -> "Negative"
        else -> "Zero"
    }
}



