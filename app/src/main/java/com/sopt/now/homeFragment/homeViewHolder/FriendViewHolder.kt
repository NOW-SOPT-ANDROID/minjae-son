package com.sopt.now.homeFragment.homeViewHolder

import androidx.recyclerview.widget.RecyclerView
import com.sopt.now.databinding.ItemFriendBinding
import com.sopt.now.homeFragment.HomeViewObject

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