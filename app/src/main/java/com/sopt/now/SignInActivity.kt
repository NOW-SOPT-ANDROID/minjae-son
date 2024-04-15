package com.sopt.now

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
            if (binding.etSignInId.text.toString() == userId) {
                if (binding.etSignInPw.text.toString() == userPw) {
                    Toast.makeText(
                        this,
                        getString(R.string.toast_SignInActivity_ValidSignIn), Toast.LENGTH_SHORT
                    ).show()

                    val intent = Intent(this, MainActivity::class.java) // 메인 페이지로 이동
                    intent.putExtra("ID", userId)
                    intent.putExtra("PW", userPw)
                    intent.putExtra("Name", userName)
                    intent.putExtra("Place", userPlace)
                    startActivity(intent)
                } else
                    Toast.makeText(
                        this,
                        getString(R.string.toast_SignInActivity_InvalidPw), Toast.LENGTH_SHORT
                    ).show()
            } else {
                Toast.makeText(
                    this,
                    getString(R.string.toast_SignInActivity_InvalidId), Toast.LENGTH_SHORT
                ).show()
            }
        }

        binding.btnSignInSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java) // 회원가입 페이지로 이동
            startActivity(intent)
        }
    }
}