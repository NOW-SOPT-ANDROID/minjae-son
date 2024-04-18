package com.sopt.now.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavController
import com.sopt.now.compose.screen.HomeScreen
import com.sopt.now.compose.screen.SearchScreen
import com.sopt.now.compose.screen.MyPageScreen

class HomeActivity(navController: NavController, ID: String, PW: String, Name: String, Place: String) : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}