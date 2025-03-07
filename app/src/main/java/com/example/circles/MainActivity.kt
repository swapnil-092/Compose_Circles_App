package com.example.circles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.circles.ui.screens.LoginScreen
import com.example.circles.ui.screens.RegisterScreen
import com.example.circles.ui.screens.SplashScreen
import com.example.circles.ui.theme.LoginScreenUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreenUITheme {
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Navigation()
                }
            }
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash_screen") {
        composable("splash_screen") {
            SplashScreen(navController = navController)
        }
        composable("login_screen") {
            LoginScreen(navController = navController)
        }
        composable("register_screen") {
            RegisterScreen(navController = navController)
        }
        composable("home_screen") {
            HomeScreen(navController = navController)
        }
        composable("event_detail_homescreen") {
            EventDetailScreen(navController = navController)
        }
    }
}