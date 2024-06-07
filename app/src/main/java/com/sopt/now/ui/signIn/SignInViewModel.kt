package com.sopt.now.ui.signIn

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.now.data.request.RequestSignInDto
import com.sopt.now.data.di.ServicePool
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignInViewModel : ViewModel() {
    val liveData = MutableLiveData<SignInState>()

    private val _navigateToMain = MutableLiveData<Boolean>()
    val navigateToMain: LiveData<Boolean>
        get() = _navigateToMain

    fun signIn(request: RequestSignInDto) {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                ServicePool.authService.signIn(request).execute()
            }.onSuccess {
                val memberId = it.headers()["location"]
                liveData.value = SignInState(true, "로그인 성공! 유저의 ID는 $memberId 입니둥", memberId)
                moveToMainActivity()
            }.onFailure {
                val error = it.message
                liveData.value = SignInState(false, "로그인 실패 $error", null)
            }
        }
    }

    private fun moveToMainActivity() {
        _navigateToMain.value = true
    }

    fun doneNavigatingToSignIn() {
        _navigateToMain.value = false
    }
}