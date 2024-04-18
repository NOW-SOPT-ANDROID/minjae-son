package com.sopt.now.compose.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

sealed class Profiles {
    data class MyProfile(
        @DrawableRes val profileImage: Int,
        val name: String,
        val place: String,
        val selfDescription: String,
        val enable: Boolean,
    )

    data class FriendProfile(
        @DrawableRes val profileImage: Int,
        val name: String,
        val place: String,
        val selfDescription: String,
    )
}

@Composable
fun MyProfileItem(myProfile: Profiles.MyProfile) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val painter: Painter = painterResource(id = myProfile.profileImage)
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.size(80.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = myProfile.name,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = myProfile.place,
            fontSize = 16.sp,
        )
        Spacer(modifier = Modifier.width(10.dp))
        Spacer(modifier = Modifier.weight(1f))
        Column {
            Text(
                text = myProfile.selfDescription,
                fontSize = 14.sp,
            )
            Switch(checked = myProfile.enable, onCheckedChange = null)
        }
    }
}

@Composable
fun FriendProfileItem(friend: Profiles.FriendProfile) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val painter: Painter = painterResource(id = friend.profileImage)
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = friend.name,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = friend.place,
            fontSize = 16.sp,
        )
        Spacer(modifier = Modifier.width(10.dp))
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = friend.selfDescription,
            fontSize = 14.sp,
        )
    }
}