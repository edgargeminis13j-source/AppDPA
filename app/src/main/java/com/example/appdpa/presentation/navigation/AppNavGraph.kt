package com.example.appdpa.presentation.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appdpa.presentation.auth.LoginScreen
import com.example.appdpa.presentation.auth.RegisterScreen
import com.example.appdpa.presentation.home.HomeScreen
import com.example.appdpa.presentation.permissions.GalleryPermissionScreen

@Composable
fun AppNavGraph(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home"){
        composable("login"){
            LoginScreen(navController)
        }

        composable("register"){
            RegisterScreen(navController)
        }

        composable("home"){
            DrawerScaffold(navController) {
                HomeScreen()
            }
        }

        composable("permissions"){
            DrawerScaffold(navController) {
                GalleryPermissionScreen()
            }
        }

        composable("favorites"){
            DrawerScaffold(navController) {
                Text("Proximamente pantalla de favoritos...")
            }
        }

    }
}