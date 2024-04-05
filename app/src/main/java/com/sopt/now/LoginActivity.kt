package com.sopt.now

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sopt.now.databinding.ActivityLoginBinding

class LoginActivity: AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userId = intent.getStringExtra("ID")
        val userPw = intent.getStringExtra("PW")
        val userName = intent.getStringExtra("Name")
        val userPlace = intent.getStringExtra("Place")

        binding.btnSignIn.setOnClickListener {
            if (binding.etSignInId.text.toString()== userId) {
                if (binding.etSignInPw.text.toString() == userPw) {
                    Toast.makeText(this, "로그인 되었습니다!", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this,MainActivity::class.java) // 메인 페이지로 이동
                    startActivity(intent)
                }
                else
                    Toast.makeText(this, "비밀번호가 잘못되었습니다", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "아이디가 잘못되었습니다!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnJoin.setOnClickListener {
            val intent = Intent(this,SignUpActivity::class.java) // 회원가입 페이지로 이동
            startActivity(intent)
        }
    }
}