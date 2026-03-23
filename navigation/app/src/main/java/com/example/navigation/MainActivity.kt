package com.example.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigation.components.HomeScreen
import com.example.navigation.ui.theme.NavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val usersViewModel = viewModel<UsersViewModel>();
            val navController = rememberNavController()
            Column {
                Text(
                    text = "Navigation App Example",
                    fontSize = 45.sp
                )

                NavHost(navController = navController, startDestination = "home-screen", modifier = Modifier.background(Color.Red)) {
                    composable("home-screen") {
                        Column {
                            LazyColumn() {
                                items(usersViewModel.users) { user ->
                                    Text(user.name)
                                    Button(onClick = {
                                        navController.navigate("user-page/${user.id}")
                                    }) {
                                        Text("See user")
                                    }
                                }
                            }
                            /*
                            HomeScreen({
                                navController.navigate("screen-2")
                            })

                             */
                        }
                    }
                    composable("screen-2") {
                        Column {
                            Text(
                                text = "Screen 2!",
                                fontSize = 32.sp
                            )
                            Button(onClick = {
                                navController.popBackStack()
                            }) {
                                Text("Back")
                            }
                        }
                    }
                    composable("user-page/{id}", arguments = listOf(navArgument("id") { type = NavType.IntType })) { backStackEntry ->
                        val id = backStackEntry.arguments?.getInt("id") ?: return@composable
                        val foundUser = usersViewModel.getUser(id)
                        if(foundUser!= null) {
                            Text(text = "User name: ${foundUser.name}. Id: ${foundUser.id}")
                        }



                    }
                    composable("sendArgumentsHere/{name}", arguments = listOf(navArgument("name") { type = NavType.StringType })) { backStackEntry ->
                        val name = backStackEntry.arguments?.getString("name") ?: return@composable
                        Text(text = "This is from the arguments: $name")
                    }
                    composable("send-data") {
                        Button(onClick = {
                            val stringToSend = "per"
                            // this is how the "url" will look: sendArgumentsHere/Benjamin
                            navController.navigate("sendArgumentsHere/$stringToSend")
                        }) {
                            Text("Send data")
                        }
                    }
                }
            }
        }
    }
}


