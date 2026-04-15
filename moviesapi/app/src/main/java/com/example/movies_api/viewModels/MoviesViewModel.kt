package com.example.movies_api.viewModels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies_api.Movie
import com.example.movies_api.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MoviesViewModel: ViewModel() {
    val retrofitInstance = RetrofitInstance()
    var movies: List<Movie> by mutableStateOf(listOf())
    var isLoading: Boolean by mutableStateOf(false)

    fun updateMovies() {
        isLoading = true;
        viewModelScope.launch(Dispatchers.IO) {
            movies = retrofitInstance.apiService.getAllMovies()
            isLoading = false;
        }
    }

    suspend fun waitFiveSeconds() {
        Log.d("timer", "Logged before delay call")
        // wait one second
        delay(5000)
        Log.d("timer", "Logged after 5 seconds")
    }
}