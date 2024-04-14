package com.sopt.now.compose

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun SignInTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    leadingIcon: ImageVector,
    modifier: Modifier = Modifier,
    isPassword: Boolean = false,
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
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None
    )
}

@Composable
fun SignUpTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    leadingIcon: ImageVector?,
    modifier: Modifier = Modifier,
    isPassword: Boolean = false
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp),
        label = { Text(label) },
        leadingIcon = if (leadingIcon != null) {
            { Icon(leadingIcon, contentDescription = null) }
        } else {
            null
        },
        singleLine = true,
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None
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
        (inputID.isEmpty()) -> {
            showToast(context, R.string.toast_SignIn_InvalidSignIn_IDBlank)
        }

        (inputPW.isEmpty()) -> {
            showToast(context, R.string.toast_SignIn_InvalidSignIn_PWBlank)
        }

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

fun isSignUpValid(
    navController: NavController,
    context: Context,
    ID: String,
    IDValid: Boolean,
    PW: String,
    PWValid: Boolean,
    Name: String,
    NameValid: Boolean,
    Place: String
) {
    if (ID.isEmpty()||PW.isEmpty()||
        Name.isEmpty()||Place.isEmpty())
        showToast(context, R.string.toast_SignUp_InvalidSignUp_Blank)

    else if (IDValid && PWValid && NameValid) {
        showToast(context, R.string.toast_SignUp_ValidSignUp)
        navController.navigate("SignIn?ID=$ID&PW=$PW&Name=$Name&Place=$Place")
    }

    else
        showToast(context,R.string.toast_SignUp_InvalidSignUp)
}

@Composable
fun MyPageText(
    text: String
) {
    Text(
        text = text,
        modifier = Modifier.padding(10.dp),
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
}

fun showToast(context: Context, message: Int) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}