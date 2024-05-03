package com.sopt.now.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sopt.now.data.RequestSignUpDto
import com.sopt.now.data.ResponseSignInDto
import com.sopt.now.data.ServicePool
import com.sopt.now.databinding.ActivitySignupBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {

    private val binding by lazy { ActivitySignupBinding.inflate(layoutInflater) }
    private val authService by lazy { ServicePool.authService }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        binding.btnSignUpSignUp.setOnClickListener {
            signUp()
        }
    }

    private fun signUp() {
        val signUpRequest = getSignUpRequestDto()
        authService.signUp(signUpRequest).enqueue(object : Callback<ResponseSignInDto> {
            override fun onResponse(
                call: Call<ResponseSignInDto>,
                response: Response<ResponseSignInDto>,
            ) {
                if (response.isSuccessful) {
                    val data: ResponseSignInDto? = response.body()
                    val userId = response.headers()["location"]
                    showToast("회원가입 성공 유저의 ID는 $userId 입니둥")
                    Log.d("SignUp", "data: $data, userId: $userId")
                    moveToSignInActivity()
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

    private fun moveToSignInActivity() {
        val intent = Intent(this, SignInActivity::class.java)
        startActivity(intent)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}