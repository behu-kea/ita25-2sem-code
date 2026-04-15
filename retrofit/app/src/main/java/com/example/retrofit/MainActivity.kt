package com.example.retrofit

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.retrofit.ui.theme.RetrofitTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val retroFitInstance = RetrofitInstance()

        setContent {
            var posts: List<Post> by remember { mutableStateOf(listOf()) }

            lifecycleScope.launch {
                posts = retroFitInstance.apiService.getAllPosts()

                val posta = retroFitInstance.apiService.createPost(posts[1])
                Log.d("benjain", posta.toString())
            }



            TextField(onValueChange = {}, value = "")

            runBlocking {
                delay(10000)
            }

            Text("hej")

//            LazyColumn {
//                items(posts) { post ->
//                    Text(post.title)
//                    Text(post.body)
//
//                }
//            }
        }
    }
}

