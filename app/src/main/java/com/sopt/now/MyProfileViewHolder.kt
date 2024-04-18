package com.sopt.now

import androidx.recyclerview.widget.RecyclerView
import com.sopt.now.databinding.ItemMyprofileBinding

class MyProfileViewHolder(private val binding: ItemMyprofileBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(myprofileData: MyProfile) {
        binding.run {
            ivMyProfileProfile.setImageResource(myprofileData.profileImage)
            tvMyProfilePlace.text = myprofileData.place
            tvMyProfileName.text = myprofileData.name
            tvMyProfileSelfDescription.text = myprofileData.selfDescription
        }
    }
}