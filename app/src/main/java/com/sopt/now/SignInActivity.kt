package com.sopt.now

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sopt.now.databinding.ActivitySigninBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySigninBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userId = intent.getStringExtra("ID")
        val userPw = intent.getStringExtra("PW")
        val userName = intent.getStringExtra("Name")
        val userPlace = intent.getStringExtra("Place")

        binding.btnSignInSignIn.setOnClickListener {
            if (isSignInValid(userId, userPw))
                navigateToMainActivity(userId, userPw, userName, userPlace)
        }

        binding.btnSignInSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java) // 회원가입 페이지로 이동
            startActivity(intent)
        }
    }

    private fun isSignInValid(userId: String?, userPw: String?) : Boolean {
        return when {
            binding.etSignInId.text.toString() == userId -> {
                showToast(R.string.toast_SignInActivity_InvalidId.toString())
                false
            }
            binding.etSignInPw.text.toString() != userPw -> {
                showToast(R.string.toast_SignInActivity_InvalidPw.toString())
                false
            }
            else -> {
                showToast(R.string.toast_SignInActivity_ValidSignIn.toString())
                true
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun navigateToMainActivity(userId: String?, userPw: String?, userName: String?, userPlace: String?) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("ID", userId)
        intent.putExtra("PW", userPw)
        intent.putExtra("Name", userName)
        intent.putExtra("Place", userPlace)
        startActivity(intent)
    }
}



