package com.sopt.now.compose.main.mypage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sopt.now.compose.R

@Composable
fun MyPageScreen(id: String, pw: String, name: String, place: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_mypage_profile),
            contentDescription = "Profile",
            modifier = Modifier.size(300.dp)
        )
        MyPageText(text = stringResource(R.string.txt_MyPage_Title))
        MyPageText(text = name)
        MyPageText(text = stringResource(R.string.txt_MyPage_Id))
        MyPageText(text = id)
        MyPageText(text = stringResource(R.string.txt_MyPage_Pw))
        MyPageText(text = pw)
        MyPageText(text = stringResource(R.string.txt_MyPage_Place))
        MyPageText(text = place)
    }
}

@Composable
fun MyPageText(text: String) {
    Text(
        text = text,
        modifier = Modifier.padding(10.dp),
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
}