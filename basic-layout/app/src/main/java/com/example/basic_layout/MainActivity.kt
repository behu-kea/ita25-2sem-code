package com.example.basic_layout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basic_layout.ui.theme.BasiclayoutTheme
import io.github.vinceglb.confettikit.compose.ConfettiKit
import io.github.vinceglb.confettikit.core.Party
import io.github.vinceglb.confettikit.core.emitter.Emitter
import kotlin.time.Duration.Companion.seconds

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BasiclayoutTheme {
                Greeting()
            }
        }
    }
}

@Preview
@Composable
fun Greeting() {
    Column (modifier = Modifier
        .padding(top = 23.dp)) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Red),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "😎"
            )
            Text(text = "Workout Builder",
                modifier = Modifier.padding(end = 100.dp))
            Button(onClick = {}) {
                Text("+")
            }
        }

        Box(modifier = Modifier
            .fillMaxWidth()
        ) {
            Box(modifier = Modifier
                .background(color = Color.DarkGray)
                .fillMaxWidth()
                .padding(20.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()) {
                    Text("Current Routine: Morning Pump")
                    Button(onClick = {

                    }) {
                        Text("▶️")
                    }

                    ConfettiKit(
                        modifier = Modifier.fillMaxSize(),
                        parties = listOf(
                            Party(emitter = Emitter(duration = 5.seconds).perSecond(30))
                        )
                    )
                }
            }


        }
    }

}

