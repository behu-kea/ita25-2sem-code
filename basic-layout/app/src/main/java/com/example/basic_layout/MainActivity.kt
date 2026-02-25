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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
            App()
        }
    }
}


@Preview
@Composable
fun App() {
    Column(
        modifier = Modifier
            .padding(start= 24.dp)
    ) {
        Header()

        Text("Good morning alex")

        Button(onClick = {
            println("asdasd")
        }) {
            Text("Klik på knappen")
        }
    }
}

@Preview
@Composable
fun Header() {
    Row(modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        horizontalArrangement = Arrangement
            .SpaceBetween
    ) {
        Text("☕️")

        Row {
            Text(text = "🙂", modifier = Modifier
                .padding(end = 12.dp)
            )

            Text("🛒")
        }
    }
}













/*
@Preview
@Composable
fun App2() {
    Column(modifier = Modifier.padding(24.dp)) {
        Header()

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            Row (verticalAlignment = Alignment.CenterVertically) {
                Button(onClick = {}) {
                    Text("🔎")
                }

                Text(modifier = Modifier.padding(start = 12.dp), text = "Find the perfect gifts")
            }
            Button(onClick = {}) {
                Text("🎤")
            }
        }
    }
}

@Composable
fun Header() {
    Row (modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.Yellow)
        .padding(12.dp), horizontalArrangement = Arrangement.SpaceBetween) {
        Text("For Liam")
        Text("🎁")
    }
}











@Preview
@Composable
fun Greeting2() {
    Column {
        Row(

            modifier= Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Text("🖌️")
        }

        Box(modifier = Modifier
            .size(100.dp)
            .clip(CircleShape)
            .background(color = Color.Red),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "00:24:59")
        }

        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround){
            Button(onClick = {}) {
                Text("⏸️ Pause")
            }

            Button(onClick = {}) {
                Text("Start")
            }

            Button(onClick = {}) {
                Text("Reset")
            }
        }
    }
}






@Preview
@Composable
fun Greeting1() {
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
                        val number = 2
                        if (number > 0) {
                            "Positive"
                        } else if (number < 0) {
                            "Negative"
                        } else {
                            "Zero"
                        }

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

*/