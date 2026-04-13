package com.example.movies_api

import retrofit2.http.GET

interface MoviesAPI {
    @GET("movies.json")
    suspend fun getAllMovies(): List<Movie>
}