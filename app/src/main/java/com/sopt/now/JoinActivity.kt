package com.sopt.now

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sopt.now.databinding.ActivityJoinBinding

class JoinActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJoinBinding

    fun OnCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJoinBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}