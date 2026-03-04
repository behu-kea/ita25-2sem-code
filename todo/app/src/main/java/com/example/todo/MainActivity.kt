package com.example.todo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

val TAG = "todo"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Todos()
        }
    }
}

@Composable
fun Todos() {
    val todos: MutableList<Todo> = remember {
        mutableStateListOf(Todo("Husk indkøb"), Todo("Tjek realkredit", true))
    }

    var todoText: String by remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier.padding(24.dp)) {
        Text("Todo list app")

        Text("There are ${todos.size} items. You have ${todos.filter { !it.isDone }.size} items left")

        TextField(value = todoText, onValueChange = { newText ->
            todoText = newText
        })

        Button(onClick = {
            val newTodo = Todo(todoText)
            todos.add(newTodo)
            todoText = ""
        }) {
            Text("Add to do")
        }

        LazyColumn {
            items(todos) { todo ->
                Row (verticalAlignment = Alignment.CenterVertically) {
                    Text(todo.text)

                    Checkbox(checked = todo.isDone, onCheckedChange = {
                        val todoIndex = todos.indexOf(todo)
                        val newTodo = Todo(todo.text, !todo.isDone)
                        todos[todoIndex] = newTodo
                        Log.d(TAG, "on check clicked $todoIndex")
                    })
                }
            }
        }
    }
}