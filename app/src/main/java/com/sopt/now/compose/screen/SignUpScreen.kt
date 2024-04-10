package com.sopt.now.compose.screen

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sopt.now.compose.R
@Composable
fun SignUpScreen(navController: NavController) {
    val (value, setValue) = remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        // 상태 관리를 위한 state 변수 선언
        var ID by remember { mutableStateOf("") }
        var PW by remember { mutableStateOf("") }
        var Name by remember { mutableStateOf("") }
        var Place by remember { mutableStateOf("") }
        var isIDValid by remember { mutableStateOf(false) }
        var isPWValid by remember { mutableStateOf(false) }
        var isNameValid by remember { mutableStateOf(false) }

        // Title
        Text(
            text = stringResource(R.string.txt_SignUp_Title),
            modifier = Modifier.padding(10.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        // ID 입력 필드
        TextField(
            value = ID,
            onValueChange = { newID ->
                ID = newID
                isIDValid = ID.trim().length in 6..10
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            label = { Text(stringResource(R.string.tf_SignUp_ID_Hint)) },
            leadingIcon = { Icon(Icons.Filled.Person, contentDescription = "ID Icon") },
            singleLine = true,
        )

        // PW 입력 필드
        TextField(
            value = PW,
            onValueChange = { newPW ->
                PW = newPW
                isPWValid = PW.trim().length in 8..12
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            label = { Text(stringResource(R.string.tf_SignUp_PW_Hint)) },
            leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "PW Icon") },
            singleLine = true,
        )

        // Name(닉네임) 입력 필드
        TextField(
            value = Name,
            onValueChange = { newName ->
                Name = newName
                isNameValid = Name.trim().isNotEmpty()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            label = { Text(stringResource(R.string.tf_SignUp_Name_Hint)) },
            leadingIcon = { Icon(Icons.Filled.Face, contentDescription = "Name Icon") },
            singleLine = true,
        )

        // Place(거주지) 입력 필드
        TextField(
            value = Place,
            onValueChange = { newPlace -> Place = newPlace },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            label = { Text(stringResource(R.string.tf_SignUp_Place_Hint)) },
            leadingIcon = { Icon(Icons.Filled.Home, contentDescription = "Place Icon") },
            singleLine = true,
        )

        // Sign Up
        Button(
            onClick = {
                navController.navigate("SignIn?ID=$ID&PW=$PW&Name=$Name&Place=$Place")
            },
            modifier = Modifier.padding(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(stringResource(R.string.btn_SignUp_SignUp), color = Color.Black)
        }
    }

}
