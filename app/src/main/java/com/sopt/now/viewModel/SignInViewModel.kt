package com.sopt.now.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sopt.now.data.RequestSignInDto
import com.sopt.now.data.ResponseSignInDto
import com.sopt.now.ServicePool
import com.sopt.now.state.SignInState
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInViewModel : ViewModel() {
    private val authService by lazy { ServicePool.authService }
    val liveData = MutableLiveData<SignInState>()

    private val _navigateToMain = MutableLiveData<Boolean>()
    val navigateToMain: LiveData<Boolean>
        get() = _navigateToMain

    fun signIn(request: RequestSignInDto) {
        authService.signIn(request).enqueue(object : Callback<ResponseSignInDto> {
            override fun onResponse(
                call: Call<ResponseSignInDto>,
                response: Response<ResponseSignInDto>,
            ) {
                if (response.isSuccessful) {
                    val data: ResponseSignInDto? = response.body()
                    val userId = response.headers()["location"]
                    liveData.value = SignInState(
                        isSuccess = true,
                        message = "로그인 성공! 유저의 ID는 $userId 입니둥"
                    )
                    Log.d("SignIn", "data: $data, userId: $userId")
                    moveToMainActivity()
                } else {
                    val error = response.message()
                    liveData.value = SignInState(
                        isSuccess = false,
                        message = "로그인 실패 $error"
                    )
                }
            }

            override fun onFailure(call: Call<ResponseSignInDto>, t: Throwable) {
                liveData.value = SignInState(
                    isSuccess = false,
                    message = "서버에러"
                )
            }
        })
    }
    private fun moveToMainActivity() {
        _navigateToMain.value = true
    }

    fun doneNavigatingToMain() {
        _navigateToMain.value = false
    }
}