package com.example.genai.viewModels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.genai.RetrofitInstance
import com.example.genai.models.LlmMessage
import com.example.genai.models.LlmRequestBody
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GenAIViewModel: ViewModel() {
    val retrofitInstance = RetrofitInstance()
    var llmText by mutableStateOf("")

    fun fetchLLM() {
        viewModelScope.launch(Dispatchers.IO) {
            val llmMessage = LlmMessage("user", "How far is the moon from earth?")
            val llmRequestBody = LlmRequestBody("mistral-large-latest", listOf(llmMessage))
            val response = retrofitInstance.apiService.getCompletion(llmRequestBody)
            //Log.d("llm", response.toString())

            val messageFromAI = response.choices[0].message.content
            Log.d("llm", messageFromAI)
            llmText = messageFromAI
        }
    }
}