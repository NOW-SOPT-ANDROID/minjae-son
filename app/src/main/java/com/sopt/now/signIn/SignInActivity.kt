package com.sopt.now.signIn

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.sopt.now.main.MainActivity
import com.sopt.now.signUp.SignUpActivity
import com.sopt.now.databinding.ActivitySigninBinding

class SignInActivity : AppCompatActivity() {

    private val binding by lazy { ActivitySigninBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<SignInViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initViews()
        initObserver()
    }

    private fun initViews() {
        binding.btnSignInSignIn.setOnClickListener {
            viewModel.signIn(getSignInRequestDto())
        }

        binding.btnSignInSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initObserver() {
        viewModel.liveData.observe(this) {
            SignInState ->
            Toast.makeText(this,SignInState.message,Toast.LENGTH_SHORT).show()
            if(SignInState.isSuccess) {
                val intent = Intent(this@SignInActivity, MainActivity::class.java).apply{
                    SignInState.memberId?.let { memberId -> putExtra("memberId",memberId) }
                }
                startActivity(intent)
            }
        }
    }

    private fun getSignInRequestDto(): RequestSignInDto {
        val id = binding.etSignInId.text.toString()
        val password = binding.etSignInPw.text.toString()
        return RequestSignInDto(
            authenticationId = id,
            password = password,
        )
    }
}