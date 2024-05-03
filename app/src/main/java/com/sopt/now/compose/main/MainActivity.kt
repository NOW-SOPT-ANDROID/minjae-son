package com.sopt.now.compose.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sopt.now.compose.Scaffold
import com.sopt.now.compose.signIn.SignInScreen
import com.sopt.now.compose.signUp.SignUpScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "SignIn") {
                composable("SignIn?ID={ID}&PW={PW}&Name={Name}&Place={Place}") { backStackEntry ->
                    SignInScreen(
                        navController = navController,
                        ID = backStackEntry.arguments?.getString("ID") ?: "",
                        PW = backStackEntry.arguments?.getString("PW") ?: "",
                        Name = backStackEntry.arguments?.getString("Name") ?: "",
                        Place = backStackEntry.arguments?.getString("Place") ?: ""
                    )
                }
                composable("SignUp") {
                    SignUpScreen(navController = navController)
                }
                composable("Home?ID={ID}&PW={PW}&Name={Name}&Place={Place}") { backStackEntry ->
                    Scaffold(
                        ID = backStackEntry.arguments?.getString("ID") ?: "",
                        PW = backStackEntry.arguments?.getString("PW") ?: "",
                        Name = backStackEntry.arguments?.getString("Name") ?: "",
                        Place = backStackEntry.arguments?.getString("Place") ?: ""
                    )
                }
            }
        }
    }
}