package com.sopt.now.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sopt.now.compose.screen.MyPageScreen
import com.sopt.now.compose.screen.SignInScreen
import com.sopt.now.compose.screen.SignUpScreen

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
                composable("MyPage?ID={InputID}&PW={InputPW}&Name={Name}&Place={Place}") { backStackEntry ->
                    MyPageScreen(
                        ID = backStackEntry.arguments?.getString("InputID") ?: "",
                        PW = backStackEntry.arguments?.getString("InputPW") ?: "",
                        Name = backStackEntry.arguments?.getString("Name") ?: "",
                        Place = backStackEntry.arguments?.getString("Place") ?: ""
                    )
                }
            }
        }
    }
}