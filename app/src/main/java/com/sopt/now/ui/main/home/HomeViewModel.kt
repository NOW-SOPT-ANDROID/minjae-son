package com.sopt.now.ui.main.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import com.sopt.now.R
import com.sopt.now.data.repository.FriendRepository
import com.sopt.now.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(
    private val userRepository: UserRepository,
    private val friendRepository: FriendRepository,
) : ViewModel() {

    private val _userInfo = MutableLiveData<HomeData.UserProfile?>()
    val userInfo: LiveData<HomeData.UserProfile?>
        get() = _userInfo

    private val _friendsInfo = MutableLiveData<List<HomeData.FriendProfile>?>()
    val friendsInfo: LiveData<List<HomeData.FriendProfile>?>
        get() = _friendsInfo

    fun fetchUserInfo(memberId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                userRepository.getUserInfo(memberId)
            }.onSuccess {
                val responseUserInfoDto = it.body()
                val userProfileInfo = responseUserInfoDto?.data?.let { userData ->
                    HomeData.UserProfile(
                        R.drawable.sonminjae_profile,
                        userData.nickname,
                        userData.phone,
                        userData.authenticationId
                    )
                }
                _userInfo.postValue(userProfileInfo)
            }.onFailure {
                Log.e("HomeViewModel", it.message.toString())
            }
        }
    }

    fun fetchFriendsInfo() {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                friendRepository.getFriendsInfo(2)
            }.onSuccess {
                val responseFriendsInfoDto = it.body()
                val friendProfiles = responseFriendsInfoDto?.data?.map { friendData ->
                    HomeData.FriendProfile(
                        friendData.avatar,
                        "${friendData.firstName} ${friendData.lastName}",
                        friendData.email
                    )
                }
                _friendsInfo.postValue(friendProfiles)
            }.onFailure {
                Log.e("HomeViewModel", it.message.toString())
            }
        }
    }

    fun updateUserProfileUI(view: RecyclerView, it: HomeData.UserProfile) {
        val adapter = view.adapter as? HomeViewAdapter
        adapter?.setUserProfileList(it)
    }


    fun updateFriendProfilesUI(view: RecyclerView, it: List<HomeData.FriendProfile>) {
        val adapter = view.adapter as? HomeViewAdapter
        adapter?.setFriendProfileList(it)
    }
}