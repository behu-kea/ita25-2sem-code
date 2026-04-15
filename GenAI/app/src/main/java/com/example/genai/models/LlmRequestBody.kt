package com.example.genai.models

data class LlmRequestBody (val model: String, val messages: List<LlmMessage>)
