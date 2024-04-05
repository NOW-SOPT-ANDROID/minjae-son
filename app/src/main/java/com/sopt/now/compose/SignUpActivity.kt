package com.sopt.now.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sopt.now.compose.ui.theme.NOWSOPTAndroidTheme
import java.util.jar.Attributes.Name

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NOWSOPTAndroidTheme {
                SignUpScreen()
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun SignUpScreen() {
    NOWSOPTAndroidTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp),) {
            // 상태 관리를 위한 state 변수 선언
            var ID by remember { mutableStateOf("") }
            var PW by remember { mutableStateOf("") }
            var Name by remember { mutableStateOf("") }
            var Place by remember { mutableStateOf("") }

            // Title
            Text(
                text = "SIGN UP",
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
                label = { Text("아이디를 입력하세요") },
                leadingIcon = { Icon(Icons.Filled.Person, contentDescription = "ID Icon") },
                singleLine = true,
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

            // Name(닉네임) 입력 필드
            TextField(
                value = Name,
                onValueChange = { Name = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                label = { Text("닉네임을 입력하세요") },
                leadingIcon = { Icon(Icons.Filled.Face, contentDescription = "Name Icon") },
                singleLine = true,
            )

            // Place(거주지) 입력 필드
            TextField(
                value = Place,
                onValueChange = { Place = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                label = { Text("거주지를 입력하세요") },
                leadingIcon = { Icon(Icons.Filled.Home, contentDescription = "Place Icon") },
                singleLine = true,
            )

            // Sign Up
            Button(
                onClick = { /* 클릭 시 수행될 동작 */ },
                modifier = Modifier.padding(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("회원가입 하기",color= Color.Black)
            }
        }
    }
}
