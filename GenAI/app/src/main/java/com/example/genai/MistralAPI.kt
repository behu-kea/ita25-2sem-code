package com.example.genai

import com.example.genai.models.LlmRequestBody
import com.example.genai.models.LlmResponse
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface MistralAPI {
    @Headers("Authorization: Bearer xCMfpxu1QO9L88QoDZe8NzXO4GNb1RF4")
    @POST("v1/chat/completions")
    suspend fun getCompletion(@Body llmRequestBody: LlmRequestBody): LlmResponse
}

/*
{
    "model": "mistral-large-latest",
    "messages": [
    {
        "role": "user",
        "content": "How far is the moon from earth?"
    }
    ]
}

 */