package com.sopt.now.ui.signIn

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sopt.now.data.request.RequestSignInDto
import com.sopt.now.data.response.ResponseSignInDto
import com.sopt.now.data.di.ServicePool
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInViewModel : ViewModel() {
    private val authService by lazy { ServicePool.authService }
    val liveData = MutableLiveData<SignInState>()

    fun signIn(request: RequestSignInDto) {
        authService.signIn(request).enqueue(object : Callback<ResponseSignInDto> {
            override fun onResponse(
                call: Call<ResponseSignInDto>,
                response: Response<ResponseSignInDto>,
            ) {
                if (response.isSuccessful) {
                    val data: ResponseSignInDto? = response.body()
                    val memberId = response.headers()["location"]
                    liveData.value = SignInState(
                        isSuccess = true,
                        message = "로그인 성공! 유저의 ID는 $memberId 입니둥",
                        memberId = memberId
                    )
                    Log.d("SignIn", "data: $data, userId: $memberId")
                } else {
                    val error = response.message()
                    liveData.value = SignInState(
                        isSuccess = false,
                        message = "로그인 실패 $error",
                        memberId = null
                    )
                }
            }

            override fun onFailure(call: Call<ResponseSignInDto>, t: Throwable) {
                liveData.value = SignInState(
                    isSuccess = false,
                    message = "서버 에러",
                    memberId = null
                )
            }
        })
    }
}