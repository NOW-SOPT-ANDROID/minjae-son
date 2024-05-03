package com.sopt.now.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.sopt.now.data.RequestSignInDto
import com.sopt.now.databinding.ActivitySigninBinding
import com.sopt.now.viewModel.SignInViewModel
import retrofit2.Callback
import retrofit2.Response

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
    }

    private fun initObserver() {
        viewModel.liveData.observe(this) {
            showToast(it.message)
        }

        viewModel.navigateToMain.observe(this) { navigate ->
            if (navigate) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                // Activity 이동 후 navigateToSignIn 값을 재설정하여 다음 이벤트에 대비
                viewModel.doneNavigatingToMain()
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

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}