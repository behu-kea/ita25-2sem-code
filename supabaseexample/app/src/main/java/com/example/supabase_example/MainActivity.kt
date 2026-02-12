package com.example.supabase_example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.supabase_example.ui.theme.SupabaseexampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SupabaseexampleTheme {
                val notesViewModel = viewModel<InstrumentViewModel>();

                InstrumentsList(notesViewModel)
            }
        }
    }
}

@Composable
fun InstrumentsList(notesViewModel: InstrumentViewModel) {
    Column() {
        LazyColumn {
            items(
                notesViewModel.instruments,
            ) { instrument ->
                Text(
                    instrument.name,
                    modifier = Modifier.padding(8.dp),
                )
            }
        }

        Column {
            Button(onClick = {
                notesViewModel.updateInstruments()
            }) {
                Text("Get newest instruments")
            }

            Button(onClick = {
                notesViewModel.createInstrument()
            }) {
                Text("Create new instrument")
            }

            Button(onClick = {
                notesViewModel.deleteRandomInstrument()
            }) {
                Text("Delete instrument")
            }
        }
    }


}