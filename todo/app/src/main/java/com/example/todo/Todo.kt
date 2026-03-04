package com.example.todo

class Todo (val text: String, var isDone: Boolean = false) {
    override fun toString(): String {
        return "Todo(text='$text', isDone=$isDone)"
    }
}