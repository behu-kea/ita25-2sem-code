package com.example.movies_api

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.movies_api.viewModels.MoviesViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val notesViewModel = viewModel<MoviesViewModel>();

            lifecycleScope.launch {
                notesViewModel.waitFiveSeconds()
            }

            Column {
                Button(onClick = {
                    notesViewModel.updateMovies()
                }) {
                    Text("Update movies")
                }

                if (notesViewModel.isLoading) {
                    Text("Fetching movies")
                }

                LazyColumn {
                    items(notesViewModel.movies) { movie ->
                        Text(movie.title)
                    }
                }
            }


        }
    }
}

