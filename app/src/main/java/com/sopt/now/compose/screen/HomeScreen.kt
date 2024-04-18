package com.sopt.now.compose.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import java.lang.reflect.Modifier

@Composable
fun HomeScreen() {
    LazyColumn(modifier = Modifier
        .fillMaxSize()) {
        // User
        item {
            TextWithRow(
                R.drawable.img_user_profile_dororo,
                "user profile img",
                75.dp,
                user.nickname,
                18.sp,
                "나 ${user.age}세 응애",
                14.sp,
                YellowMain,
                15.dp,
                12.dp,
            )
        }

        // Friend
        items(mockFriendList) { friend ->
            TextWithRow(
                friend.profileImage,
                "friend profile img",
                50.dp,
                friend.name,
                16.sp,
                friend.selfDescription,
                13.sp,
                GreenMain,
                8.dp,
                10.dp,
            )
        }
    }
}

val friendList = listOf(

)
