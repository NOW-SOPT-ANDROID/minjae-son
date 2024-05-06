package com.sopt.now.main.homeFragment.homeViewHolder

import androidx.recyclerview.widget.RecyclerView
import com.sopt.now.databinding.ItemFriendBinding
import com.sopt.now.main.homeFragment.HomeViewObject

class FriendViewHolder(private val binding: ItemFriendBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(friendData: HomeViewObject.FriendProfile) {
        binding.run {
            ivFriendProfile.setImageResource(friendData.profileImage)
            tvFriendName.text = friendData.name
            tvFriendPhoneNumber.text = friendData.phoneNumber
            tvFriendSelfDescription.text = friendData.selfDescription
        }
    }
}