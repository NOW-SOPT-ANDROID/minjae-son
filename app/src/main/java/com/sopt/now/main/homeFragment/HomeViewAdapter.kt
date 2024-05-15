package com.sopt.now.main.homeFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sopt.now.databinding.ItemFriendBinding
import com.sopt.now.databinding.ItemUserBinding

class HomeViewAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var userProfile: HomeData.UserProfile? = null
    private var friendsProfile: List<HomeData.FriendProfile>? = null

    companion object {
        const val TYPE_MY_PROFILE = 0
        const val TYPE_FRIEND_PROFILE = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            TYPE_MY_PROFILE -> {
                val binding = ItemUserBinding.inflate(inflater, parent, false)
                HomeViewHolder.UserViewHolder(binding)
            }

            TYPE_FRIEND_PROFILE -> {
                val binding = ItemFriendBinding.inflate(inflater, parent, false)
                HomeViewHolder.FriendViewHolder(binding)
            }

            else -> throw IllegalArgumentException("오류")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {
            is HomeViewHolder.UserViewHolder -> {
                userProfile?.let { holder.onBind(it) }
            }

            is HomeViewHolder.FriendViewHolder -> {
                friendsProfile?.getOrNull(position - 1)?.let { holder.onBind(it) }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) TYPE_MY_PROFILE else TYPE_FRIEND_PROFILE
    }

    override fun getItemCount(): Int {
        return friendsProfile?.size?.plus(1) ?: 0
    }

    fun setUserProfileList(
        myProfile: HomeData.UserProfile?,
    ) {
        if (myProfile != null) {
            this.userProfile = myProfile
        }
        notifyDataSetChanged()
    }

    fun setFriendProfileList(
        friendProfileList: List<HomeData.FriendProfile>?
    ) {
        if (friendProfileList != null) {
            this.friendsProfile = friendProfileList
        }
        notifyDataSetChanged()
    }
}