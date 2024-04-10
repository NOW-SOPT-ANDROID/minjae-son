package com.sopt.now.compose.screen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sopt.now.compose.R

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
            text = stringResource(id = R.string.txt_SignIn_Title ),
            modifier = Modifier.padding(10.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        SOPTTextField(
            inputID,
            { inputID = it },
            stringResource(id = R.string.tf_SignUp_ID_Hint),
            Icons.Filled.Person
        )

        SOPTTextField(
            inputPW,
            { inputPW = it },
            stringResource(id = R.string.tf_SignUp_PW_Hint ),
            Icons.Filled.Person
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

@Composable
fun SOPTTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    leadingIcon: ImageVector,
    modifier: Modifier = Modifier,
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp),
        label = { Text(label) },
        leadingIcon = { Icon(leadingIcon, contentDescription = null) },
        singleLine = true,
    )
}

@Composable
fun SOPTOutlinedButton(text: Int, onClick: () -> Unit, enabled: Boolean) {
    OutlinedButton(
        onClick = onClick, modifier = Modifier.fillMaxWidth(), enabled = enabled
    ) {
        Text(text = stringResource(id = text))
    }
}

fun isSignInValid(
    navController: NavController,
    context: Context,
    inputID: String,
    inputPW: String,
    ID: String,
    PW: String,
    Name: String,
    Place: String
) {
    when {
        (inputID == ID && inputPW == PW) -> {
            showToast(context, R.string.toast_SignIn_ValidSignIn)
            navController.navigate("MyPage?ID=$inputID&PW=$inputPW&Name=$Name&Place=$Place")
        }

        (inputID != ID) -> {
            showToast(context, R.string.toast_SignIn_InvalidID)
        }

        (inputPW != PW) -> {
            showToast(context, R.string.toast_SignIn_InvalidPW)
        }
    }
}

fun showToast(context: Context, message: Int) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}