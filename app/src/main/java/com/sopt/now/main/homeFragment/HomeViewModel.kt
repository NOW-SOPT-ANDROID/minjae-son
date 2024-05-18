package com.sopt.now.main.homeFragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.sopt.now.R
import com.sopt.now.main.ResponseUserInfoDto
import com.sopt.now.service.ServicePool
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    private val _userInfo = MutableLiveData<HomeData.UserProfile?>()
    val userInfo: LiveData<HomeData.UserProfile?>
        get() = _userInfo

    private val _friendsInfo = MutableLiveData<List<HomeData.FriendProfile>?>()
    val friendsInfo: LiveData<List<HomeData.FriendProfile>?>
        get() = _friendsInfo

    private val userService by lazy { ServicePool.userService }
    private val friendService by lazy { ServicePool.friendService }

    fun fetchUserInfo(userId: Int) {
        userService.getUserInfo(userId).enqueue(object : Callback<ResponseUserInfoDto> {
            override fun onResponse(
                call: Call<ResponseUserInfoDto>,
                response: Response<ResponseUserInfoDto>
            ) {
                if (response.isSuccessful) {
                    val responseUserInfoDto = response.body()
                    val userProfileInfo = responseUserInfoDto?.data?.let { userData ->
                        HomeData.UserProfile(
                            R.drawable.sonminjae_profile,
                            userData.nickname,
                            userData.phone,
                            userData.authenticationId)
                        }
                    _userInfo.value = userProfileInfo
                }
            }
            override fun onFailure(call: Call<ResponseUserInfoDto>, t: Throwable) {
                Log.e("HomeViewModel", t.message.toString())
            }
        })
    }

    fun fetchFriendsInfo() {
        friendService.getFriendsInfo(2).enqueue(object : Callback<ResponseFriendsInfoDto> {
            override fun onResponse(
                call: Call<ResponseFriendsInfoDto>,
                response: Response<ResponseFriendsInfoDto>
            ) {
                if (response.isSuccessful) {
                    val responseFriendsInfoDto = response.body()
                    val friendProfiles = responseFriendsInfoDto?.data?.map { friendData ->
                        HomeData.FriendProfile(
                            friendData.avatar,
                            "${friendData.firstName} ${ friendData.lastName}",
                            friendData.email
                        )
                    }
                    _friendsInfo.postValue(friendProfiles)
                }
            }

            override fun onFailure(call: Call<ResponseFriendsInfoDto>, t: Throwable) {
                Log.e("HomeViewModel", t.message.toString())
            }
        })
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