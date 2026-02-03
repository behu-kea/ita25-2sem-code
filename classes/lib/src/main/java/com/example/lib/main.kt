package com.example.lib

fun main() {
    /*
    val ageFromUser = getAgeFromUser();
    val canUserVote = canVote(ageFromUser);
    ¨
     */

    val benjaminsSamusungPhone = Mobile("Samsung", 5000f);
    println(benjaminsSamusungPhone)
    println(benjaminsSamusungPhone.getDiscount())

    val persIphone = Mobile("Apple", 10000f)
    println(persIphone)

}

/*
fun calculateAverage() {
    val myList = listOf(7, 4, 9, 13, 15)
        ...
}
¨
 */



fun getAgeFromUser (): Int {
    print("Enter your age: ")
    val ageInput = readLine()!!  // https://www.youtube.com/watch?v=XkBYH9vLs50
    val ageInt = ageInput.toInt()

    return ageInt;
}

fun canVote(age: Int): Boolean {
    return age >= 18;
}