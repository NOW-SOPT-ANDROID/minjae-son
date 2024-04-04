package com.sopt.now

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.sopt.now.databinding.ActivityLoginBinding

class LoginActivity: AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignIn.setOnClickListener {
            if (binding.etSignInId.text.length in 6..10) {
                if (binding.etSignInPw.text.length in 8..12)
                    Toast.makeText(this, "로그인 되었습니다!", Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(this, "비밀번호가 잘못되었습니다", Toast.LENGTH_SHORT).show()
            }
            else Toast.makeText(this, "아이디가 잘못되었습니다!", Toast.LENGTH_SHORT).show()
        }

        binding.btnJoin.setOnClickListener {
            val intent = Intent(this,SignUpActivity::class.java) // 회원가입 페이지로 이동
            startActivity(intent)
        }
    }
}