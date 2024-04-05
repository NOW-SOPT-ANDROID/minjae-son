package com.sopt.now

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sopt.now.databinding.ActivityLoginBinding
import com.sopt.now.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userId = intent.getStringExtra("ID")
        val userPw = intent.getStringExtra("PW")
        val userName = intent.getStringExtra("Name")
        val userPlace = intent.getStringExtra("Place")

        binding.tvMainName.text = userName
        binding.tvMainShowId.text = userId
        binding.tvMainShowPw.text = userPw
        binding.tvMainShowPlace.text = userPlace
    }
}