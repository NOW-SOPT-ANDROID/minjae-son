package com.sopt.now.homeFragment.homeViewHolder

import androidx.recyclerview.widget.RecyclerView
import com.sopt.now.homeFragment.HomeViewObject
import com.sopt.now.databinding.ItemMyprofileBinding

class MyProfileViewHolder(private val binding: ItemMyprofileBinding) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(myprofileData: HomeViewObject.MyProfile) {
        binding.run {
            ivMyProfileProfile.setImageResource(myprofileData.profileImage)
            tvMyProfileName.text = myprofileData.name
            tvMyProfilePlace.text = myprofileData.place
            tvMyProfileSelfDescription.text = myprofileData.selfDescription
            switchMyProfileEnable
        }
    }
}
