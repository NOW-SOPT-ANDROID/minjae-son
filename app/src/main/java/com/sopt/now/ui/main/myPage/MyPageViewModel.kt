package com.sopt.now.ui.main.myPage

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.now.data.repository.AuthRepository
import com.sopt.now.data.repository.UserRepository
import com.sopt.now.data.response.ResponseUserInfoDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel
@Inject constructor(
    private val userRepository: UserRepository
): ViewModel() {
    private val _userInfo = MutableLiveData<ResponseUserInfoDto>()
    val userInfo: LiveData<ResponseUserInfoDto>
        get() = _userInfo

    fun fetchUserInfo(memberId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                userRepository.getUserInfo(memberId)
            }.onSuccess {
                _userInfo.postValue(it.body())
            }.onFailure {
                Log.e("MyPageViewModel", it.message.toString())
            }
        }
    }
}
