package com.sopt.now

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sopt.now.databinding.ActivitySignupBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignUpSignUp.setOnClickListener {
            if (binding.etSignUpId.text.length in 6..10 &&
                binding.etSignUpPw.text.length in 8..12 &&
                binding.etSignUpName.text.isNotEmpty() &&
                binding.etSignUpPlace.text.isNotEmpty()
            ) {

                Toast.makeText(
                    this,
                    getString(R.string.toast_SignUpActivity_ValidSignUp), Toast.LENGTH_SHORT
                ).show()

                val intent = Intent(this, SignInActivity::class.java) // 회원가입 성공 시, 로그인 화면으로 이동
                // 회원가입 정보 넘기기
                intent.putExtra("ID", binding.etSignUpId.text.toString())
                intent.putExtra("PW", binding.etSignUpPw.text.toString())
                intent.putExtra("Name", binding.etSignUpName.text.toString())
                intent.putExtra("Place", binding.etSignUpPlace.text.toString())
                startActivity(intent)
            } else if (binding.etSignUpId.text.isEmpty() || binding.etSignUpPw.text.isEmpty() ||
                binding.etSignUpName.text.isEmpty() || binding.etSignUpPlace.text.isEmpty()
            ) {
                Toast.makeText(
                    this,
                    getString(R.string.toast_SignUpActivity_InvalidSignUp_Blank), Toast.LENGTH_SHORT
                ).show()
            } else
                Toast.makeText(
                    this,
                    getString(R.string.toast_SignUpActivity_InvalidSignUp), Toast.LENGTH_SHORT
                ).show()
        }
    }
}