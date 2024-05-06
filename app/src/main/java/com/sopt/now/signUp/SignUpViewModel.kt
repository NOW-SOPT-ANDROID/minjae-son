package com.sopt.now.signUp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sopt.now.service.ServicePool
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpViewModel : ViewModel() {
    private val authService by lazy { ServicePool.authService }
    val liveData = MutableLiveData<SignUpState>()

    private val _navigateToSignIn = MutableLiveData<Boolean>()
    val navigateToSignIn: LiveData<Boolean>
        get() = _navigateToSignIn

    fun signUp(request: RequestSignUpDto) {

        authService.signUp(request).enqueue(object : Callback<ResponseSignUpDto> {
            override fun onResponse(
                call: Call<ResponseSignUpDto>,
                response: Response<ResponseSignUpDto>,
            ) {
                if (response.isSuccessful) {
                    val data: ResponseSignUpDto? = response.body()
                    val userId = response.headers()["location"]
                    liveData.value = SignUpState(
                        isSuccess = true,
                        message = "회원가입 성공! 유저의 ID는 $userId 입니둥"
                    )
                    Log.d("SignUp", "data: $data, userId: $userId")
                    moveToSignInActivity()
                } else {
                    val error = response.message()
                    liveData.value = SignUpState(
                        isSuccess = false,
                        message = "회원가입 실패 $error"
                    )
                }
            }

            override fun onFailure(call: Call<ResponseSignUpDto>, t: Throwable) {
                liveData.value = SignUpState(
                    isSuccess = false,
                    message = "서버에러"
                )
            }
        })
    }

    private fun moveToSignInActivity() {
        _navigateToSignIn.value = true
    }

    fun doneNavigatingToSignIn() {
        _navigateToSignIn.value = false
    }
}