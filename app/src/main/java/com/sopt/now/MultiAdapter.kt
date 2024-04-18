//package com.sopt.now
//
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//
//
//class MultiAdapter(private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//
//    companion object {
//        private const val VIEW_TYPE_PROFILE = 0
//        private const val VIEW_TYPE_FRIEND = 1
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        return when (viewType) {
//            VIEW_TYPE_PROFILE -> {
//                val myprofileView = LayoutInflater.from(context).inflate(R.layout.item_myprofile, parent, false)
//                MyProfileViewHolder(myprofileView)
//            }
//            VIEW_TYPE_FRIEND -> {
//                val friendView = LayoutInflater.from(context).inflate(R.layout.item_friend, parent, false)
//                FriendViewHolder(friendView)
//            }
//            else -> throw IllegalArgumentException("Invalid view type")
//        }
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        // 위치에 따라서 다른 뷰 홀더를 바인딩합니다.
//        when (getItemViewType(position)) {
//            VIEW_TYPE_PROFILE -> {
//                // 프로필 데이터를 바인딩합니다.
//                // (holder as ProfileViewHolder).bind(profileData[position])
//            }
//            VIEW_TYPE_FRIEND -> {
//                // 친구 목록 데이터를 바인딩합니다.
//                // (holder as FriendViewHolder).bind(friendList[position - 1]) // 프로필 아이템이 있기 때문에 인덱스가 하나씩 빼집니다.
//            }
//        }
//    }
//
//    override fun getItemCount(): Int {
//        // 프로필 아이템과 친구 목록의 합계에 1을 더합니다.
//        return friendList.size + 1
//    }
//
//    override fun getItemViewType(position: Int): Int {
//        return when (position) {
//            0 -> VIEW_TYPE_PROFILE
//            else -> VIEW_TYPE_FRIEND
//        }
//    }
//}