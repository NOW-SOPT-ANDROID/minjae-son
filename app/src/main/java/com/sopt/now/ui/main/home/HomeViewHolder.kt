package com.sopt.now.ui.main.home

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sopt.now.databinding.ItemFriendBinding
import com.sopt.now.databinding.ItemUserBinding

class HomeViewHolder {
    class UserViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(userInfo: HomeData.UserProfile) {
            binding.run {
                Glide.with(root.context).load(userInfo.profileImg).into(ivUserProfile)
                tvUserName.text = userInfo.name
                tvUserPhoneNumber.text = userInfo.phoneNumber
                tvUserAuthenticationId.text = userInfo.authenticationId
            }
        }
    }

    class FriendViewHolder(private val binding: ItemFriendBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(friendInfo: HomeData.FriendProfile) {
            binding.run {
                Glide.with(root.context).load(friendInfo.profileImg).into(ivFriendProfile)
                tvFriendName.text = friendInfo.name
                tvFriendSelfDescription.text = friendInfo.authenticationId
            }
        }
    }
}


