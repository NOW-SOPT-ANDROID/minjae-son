package com.sopt.now.ui.signUp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.now.data.repository.AuthRepository
import com.sopt.now.data.request.RequestSignUpDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel
@Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {
    val liveData = MutableLiveData<SignUpState>()

    private val _navigateToSignIn = MutableLiveData<Boolean>()
    val navigateToSignIn: LiveData<Boolean>
        get() = _navigateToSignIn

    fun signUp(request: RequestSignUpDto) {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                authRepository.signUp(request)
            }.onSuccess {
                liveData.postValue(SignUpState(true, "회원가입 성공"))
                moveToSignInActivity()
            }.onFailure {
                liveData.postValue(SignUpState(false, "회원가입 실패"))
            }
        }
    }

    private fun moveToSignInActivity() {
        _navigateToSignIn.postValue(true)
    }

    fun doneNavigatingToSignIn() {
        _navigateToSignIn.postValue(false)
    }
}