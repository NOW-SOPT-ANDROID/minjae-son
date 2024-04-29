package com.sopt.now.homeFragment.homeViewHolder

import androidx.recyclerview.widget.RecyclerView
import com.sopt.now.databinding.ItemMyprofileBinding
import com.sopt.now.homeFragment.HomeViewObject

class MyProfileViewHolder(private val binding: ItemMyprofileBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(myProfileData: HomeViewObject.MyProfile) {
        binding.run {
            ivMyProfileProfile.setImageResource(myProfileData.profileImage)
            tvMyProfileName.text = myProfileData.name
            tvMyProfilePhoneNumber.text = myProfileData.phoneNumber
            tvMyProfileSelfDescription.text = myProfileData.selfDescription
            switchMyProfileEnable
        }
    }
}
