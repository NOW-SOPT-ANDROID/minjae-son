package com.sopt.now

import android.os.Bundle
import android.view.View
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
            if (binding.etSignInId.text.length >= 6) {
                if (binding.etSignInPw.text.length in 6..9)
                    Snackbar.make(it, "로그인 되었습니다!", Snackbar.LENGTH_SHORT).show()
                else
                    Snackbar.make(it,"비밀번호가 잘못되었습니다.",Snackbar.LENGTH_SHORT).show()
            }
            else Snackbar.make(it,"아이디가 잘못되었습니다.",Snackbar.LENGTH_SHORT).show()
        }
    }
}