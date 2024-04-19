package com.sopt.now.homeFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.sopt.now.databinding.ItemFriendBinding
import com.sopt.now.databinding.ItemMyprofileBinding
import com.sopt.now.homeFragment.homeViewHolder.FriendViewHolder
import com.sopt.now.homeFragment.homeViewHolder.MyProfileViewHolder

class HomeProfileAdapter() : RecyclerView.Adapter<ViewHolder>() {

    private lateinit var myProfile: HomeViewObject.MyProfile
    private var friendList: List<HomeViewObject.FriendProfile> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            TYPE_MY_PROFILE -> {
                val binding = ItemMyprofileBinding.inflate(inflater, parent, false)
                MyProfileViewHolder(binding)
            }

            TYPE_FRIEND_PROFILE -> {
                val binding = ItemFriendBinding.inflate(inflater, parent, false)
                FriendViewHolder(binding)
            }

            else -> throw IllegalArgumentException("오류")
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        when (holder) {
            is MyProfileViewHolder -> {
                holder.onBind(myProfile)
            }

            is FriendViewHolder -> {
                holder.onBind(friendList[position - 1])
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) TYPE_MY_PROFILE else TYPE_FRIEND_PROFILE
    }

    override fun getItemCount(): Int {
        return friendList.size + 1
    }

    fun setProfileList(
        myProfile: HomeViewObject.MyProfile,
        friendProfileList: List<HomeViewObject.FriendProfile>
    ) {
        this.myProfile = myProfile
        this.friendList = friendProfileList.toList()
        notifyDataSetChanged()
    }

    companion object {
        const val TYPE_MY_PROFILE = 0
        const val TYPE_FRIEND_PROFILE = 1
    }
}