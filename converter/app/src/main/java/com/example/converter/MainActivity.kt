package com.example.converter

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.math.log


val TAG = "currency"
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //Currency()
            Calculator()
        }
    }
}

@Composable
fun Calculator() {
    var calculatorDisplayString: String by remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier.padding(24.dp)) {
        Text(calculatorDisplayString)

        Button(onClick = {
            calculatorDisplayString += "1"
        }) {
            Text("1")
        }

        Button(onClick = {
            calculatorDisplayString += "2"
        }) {
            Text("2")
        }
    }
}

@Composable
fun Currency () {
    var amountString by remember {
        mutableStateOf("")
    }
    var result: Float? by remember {
        mutableStateOf(null)
    }
    Column(modifier = Modifier.padding(24.dp)) {
        Text("Currency converter")
        TextField(value = amountString, onValueChange = { newText ->
            amountString = newText
        })
        Button (onClick = {
            result = amountString.toFloat() * 5.5f
            Log.d(TAG, result.toString())
        }){
            Text("Convert")
        }
        if (result != null) {
            Text(result.toString())
        }
    }
}