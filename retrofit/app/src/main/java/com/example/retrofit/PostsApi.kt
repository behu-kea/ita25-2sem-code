package com.example.retrofit

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PostsApi {
    @GET("/posts")
    suspend fun getAllPosts(): List<Post>

    @POST("/posts")
    suspend fun createPost(@Body post: Post): Post
}