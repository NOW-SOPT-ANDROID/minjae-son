package com.sopt.now.compose.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sopt.now.compose.R
import com.sopt.now.compose.SOPTOutlinedButton
import com.sopt.now.compose.SignInTextField
import com.sopt.now.compose.isSignInValid

@Composable
fun SignInScreen(
    navController: NavController, ID: String, PW: String, Name: String, Place: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        var inputID by remember { mutableStateOf("") }
        var inputPW by remember { mutableStateOf("") }
        val context = LocalContext.current

        Text(
            text = stringResource(id = R.string.txt_SignIn_Title),
            modifier = Modifier.padding(10.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        SignInTextField(
            inputID,
            { inputID = it },
            stringResource(id = R.string.tf_SignUp_ID_Hint),
            Icons.Filled.Person
        )

        SignInTextField(
            inputPW,
            { inputPW = it },
            stringResource(id = R.string.tf_SignUp_PW_Hint),
            Icons.Filled.Lock,
            isPassword = true
        )

        SOPTOutlinedButton(
            R.string.btn_SignIn_SignIn,
            { isSignInValid(navController, context, inputID, inputPW, ID, PW, Name, Place) },
            true
        )

        SOPTOutlinedButton(
            R.string.btn_SignIn_SignUp,
            { navController.navigate("SignUp") },
            true
        )
    }
}