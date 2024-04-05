package com.sopt.now.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sopt.now.compose.ui.theme.NOWSOPTAndroidTheme

class SignInActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NOWSOPTAndroidTheme {
                SignInScreen()
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun SignInScreen() {
    NOWSOPTAndroidTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp),) {
            // 상태 관리를 위한 state 변수 선언
            var ID by remember { mutableStateOf("") }
            var PW by remember { mutableStateOf("") }

            // Title
            Text(
                text = "Welcome to SOPT!",
                modifier = Modifier.padding(10.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            // ID 입력 필드
            TextField(
                value = ID,
                onValueChange = { ID = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                label = { Text("아이디를 입력하세요") },                                    // 입력 전 보이는 텍스트
                leadingIcon = { Icon(Icons.Filled.Person, contentDescription = "ID Icon") }, // 시작 부분 아이콘
                singleLine = true,                                                           // 텍스트 단일 줄 제한
            )

            // PW 입력 필드
            TextField(
                value = PW,
                onValueChange = { PW = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                label = { Text("비밀번호를 입력하세요") },
                leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "PW Icon") },
                singleLine = true,
            )

            // Sign In
            Button(
                onClick = { /* 클릭 시 수행될 동작 */ },                                  // 버튼 클릭 시 실행되는 콜백 함수
                modifier = Modifier.padding(10.dp),                                   // 버튼의 크기, 위치, 패딩 등을 조정
                colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("로그인 하기",color=Color.Black)
            }

            // Sign Up
            Button(
                onClick = { /* 클릭 시 수행될 동작 */ },
                modifier = Modifier.padding(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("회원가입 하기",color=Color.Black)
            }
        }
    }
}