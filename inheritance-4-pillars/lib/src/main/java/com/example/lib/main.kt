package com.example.lib

fun main() {
    val per: Leader = Leader("Per");
    println(per)
    println(per.name)
    println(per.health)

    per.health = 100000000;
    println(per.health)

    val benjamin: TheGuyWhoAlwaysDiesFirst = TheGuyWhoAlwaysDiesFirst("Benjamin");

    per.fight()
    per.motivatTeam()
    benjamin.fight()
    benjamin.sayLastWords()




}

