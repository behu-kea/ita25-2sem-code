package com.example.navigation

import androidx.lifecycle.ViewModel

class UsersViewModel: ViewModel() {
    val users: List<User> =  listOf(User("Camilla", 1), User("Benjamin", 2))

    fun getUser(id: Int): User? {
        return users.find { user -> user.id == id}
    }
}