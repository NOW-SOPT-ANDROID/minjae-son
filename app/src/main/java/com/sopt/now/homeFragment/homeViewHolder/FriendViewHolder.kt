package com.sopt.now.homeFragment.homeViewHolder

import androidx.recyclerview.widget.RecyclerView
import com.sopt.now.homeFragment.HomeViewObject
import com.sopt.now.databinding.ItemFriendBinding

class FriendViewHolder(private val binding: ItemFriendBinding) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(friendData: HomeViewObject.FriendProfile) {
        binding.run {
            ivFriendProfile.setImageResource(friendData.profileImage)
            tvFriendName.text = friendData.name
            tvFriendPlace.text = friendData.place
            tvFriendSelfDescription.text = friendData.selfDescription
        }
    }
}