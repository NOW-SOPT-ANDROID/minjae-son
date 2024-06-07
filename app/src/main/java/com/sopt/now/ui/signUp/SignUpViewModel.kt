package com.sopt.now.ui.signUp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.now.data.request.RequestSignUpDto
import com.sopt.now.data.di.ServicePool
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignUpViewModel : ViewModel() {
    val liveData = MutableLiveData<SignUpState>()

    private val _navigateToSignIn = MutableLiveData<Boolean>()
    val navigateToSignIn: LiveData<Boolean>
        get() = _navigateToSignIn

    fun signUp(request: RequestSignUpDto) {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                ServicePool.authService.signUp(request)
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