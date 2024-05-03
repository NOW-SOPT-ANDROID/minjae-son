package com.sopt.now.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sopt.now.data.RequestSignInDto
import com.sopt.now.data.ResponseSignInDto
import com.sopt.now.data.ServicePool
import com.sopt.now.databinding.ActivitySigninBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInActivity : AppCompatActivity() {

    private val binding by lazy { ActivitySigninBinding.inflate(layoutInflater) }
    private val authService by lazy { ServicePool.authService }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        binding.btnSignInSignIn.setOnClickListener {
            signIn()
        }

        binding.btnSignInSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun signIn() {
        val signInRequest = getSignInRequestDto()
        authService.signIn(signInRequest).enqueue(object : Callback<ResponseSignInDto> {
            override fun onResponse(
                call: Call<ResponseSignInDto>,
                response: Response<ResponseSignInDto>,
            ) {
                if (response.isSuccessful) {
                    val data: ResponseSignInDto? = response.body()
                    val userId = response.headers()["location"]
                    showToast("로그인 성공 유저의 ID는 $userId 입니둥")
                    Log.d("SignUp", "data: $data, userId: $userId")
                    moveToMainActivity()
                } else {
                    val error = response.message()
                    showToast("로그인이 실패 $error")
                }
            }

            override fun onFailure(call: Call<ResponseSignInDto>, t: Throwable) {
                showToast("서버 에러 발생 ")
            }
        })
    }

    private fun getSignInRequestDto(): RequestSignInDto {
        val id = binding.etSignInId.text.toString()
        val password = binding.etSignInPw.text.toString()
        return RequestSignInDto(
            authenticationId = id,
            password = password,
        )
    }

    private fun moveToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}



