package com.sopt.now

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sopt.now.databinding.ItemMyprofileBinding

class MyProfileAdapter(requireContext: Context) : RecyclerView.Adapter<MyProfileViewHolder>() {

    private var myprofileList: List<MyProfile> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyProfileViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMyprofileBinding.inflate(inflater, parent, false)
        return MyProfileViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyProfileViewHolder, position: Int) {
        val myprofile = myprofileList.getOrNull(position) ?: return
        holder.onBind(myprofileList[position])
    }

    override fun getItemCount() = myprofileList.size

    fun setMyProfileList(myprofileList: List<MyProfile>) {
        this.myprofileList = myprofileList.toList()
        notifyDataSetChanged()
    }
}