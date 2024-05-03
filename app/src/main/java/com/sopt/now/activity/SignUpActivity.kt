package com.sopt.now.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.sopt.now.data.RequestSignInDto
import com.sopt.now.data.RequestSignUpDto
import com.sopt.now.databinding.ActivitySignupBinding
import com.sopt.now.viewModel.SignUpViewModel

class SignUpActivity : AppCompatActivity() {

    private val binding by lazy { ActivitySignupBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<SignUpViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initViews()
        initObserver()
    }

    private fun initViews() {
        binding.btnSignUpSignUp.setOnClickListener {
            viewModel.signUp(getSignUpRequestDto())
        }
    }

    private fun initObserver() {
        viewModel.liveData.observe(this) {
            showToast(it.message)
        }

        viewModel.navigateToSignIn.observe(this) { navigate ->
            if (navigate) {
                val intent = Intent(this, SignInActivity::class.java)
                startActivity(intent)
                // Activity 이동 후 navigateToSignIn 값을 재설정하여 다음 이벤트에 대비
                viewModel.doneNavigatingToSignIn()
            }
        }
    }

    private fun getSignUpRequestDto(): RequestSignUpDto {
        val id = binding.etSignUpId.text.toString()
        val password = binding.etSignUpPw.text.toString()
        val nickname = binding.etSignUpName.text.toString()
        val phoneNumber = binding.etSignUpPhoneNumber.text.toString()
        return RequestSignUpDto(
            authenticationId = id,
            password = password,
            nickname = nickname,
            phone = phoneNumber
        )
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}