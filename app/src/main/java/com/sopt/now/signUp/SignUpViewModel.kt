package com.sopt.now.signUp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.now.service.ServicePool
import kotlinx.coroutines.launch
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
        viewModelScope.launch {
            runCatching {
                authService.signUp(request)
            }.onSuccess {
                liveData.value = SignUpState(true, "회원가입 성공")
                moveToSignInActivity()
            }.onFailure {
                liveData.value = SignUpState(false, "회원가입 실패")
            }
        }
    }

    private fun moveToSignInActivity() {
        _navigateToSignIn.value = true
    }

    fun doneNavigatingToSignIn() {
        _navigateToSignIn.value = false
    }
}