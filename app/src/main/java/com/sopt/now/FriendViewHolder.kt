package com.sopt.now

import androidx.recyclerview.widget.RecyclerView
import com.sopt.now.databinding.ItemFriendBinding

class FriendViewHolder(private val binding: ItemFriendBinding)
    : RecyclerView.ViewHolder(binding.root) {
    fun onBind(friendData: Friend) {
        binding.run {
            ivFriendProfile.setImageResource(friendData.profileImage)
            tvFriendPlace.text = friendData.place
            tvFriendName.text = friendData.name
            tvFriendSelfDescription.text = friendData.selfDescription
        }
    }
}