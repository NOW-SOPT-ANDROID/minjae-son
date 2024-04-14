package com.sopt.now.compose.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sopt.now.compose.MyPageText
import com.sopt.now.compose.R

@Composable
fun MyPageScreen(ID: String, PW: String, Name: String, Place: String) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {


        MyPageText(text = stringResource(R.string.txt_MyPage_Title))
        MyPageText(text = Name)
        MyPageText(text = stringResource(R.string.txt_MyPage_Id))
        MyPageText(text = ID)
        MyPageText(text = stringResource(R.string.txt_MyPage_Pw))
        MyPageText(text = PW)
        MyPageText(text = stringResource(R.string.txt_MyPage_Place))
        MyPageText(text = Place)
    }
}