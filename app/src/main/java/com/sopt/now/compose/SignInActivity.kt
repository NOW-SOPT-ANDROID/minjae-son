package com.sopt.now.compose

import android.content.Intent
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
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
            SignInScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignInScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        var ID by remember { mutableStateOf("") }
        var PW by remember { mutableStateOf("") }
        val context = LocalContext.current

        // Title
        Text(
            text = stringResource(R.string.txt_SignIn_Title),
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
            label = { Text(stringResource(R.string.tf_SignIn_Id_Hint)) },
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
            label = { Text(stringResource(R.string.tf_SignIn_Pw_Hint)) },
            leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "PW Icon") },
            singleLine = true,
        )

        // Sign In
        Button(
            onClick = {
                val intent = Intent(context, MainActivity::class.java)
                context.startActivity(intent)
            },
            modifier = Modifier.padding(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(stringResource(R.string.btn_SignIn_SignIn), color = Color.Black)
        }

        // Sign Up
        Button(
            onClick = {
                val intent = Intent(context, SignUpActivity::class.java)
                context.startActivity(intent)
            },
            modifier = Modifier.padding(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(stringResource(R.string.btn_SignIn_SignUp), color = Color.Black)
        }
    }

}