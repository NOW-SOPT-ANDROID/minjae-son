package com.sopt.now.compose.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
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
import com.sopt.now.compose.SignUpTextField
import com.sopt.now.compose.isSignUpValid

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

        var ID by remember { mutableStateOf("") }
        var PW by remember { mutableStateOf("") }
        var Name by remember { mutableStateOf("") }
        var Place by remember { mutableStateOf("") }
        var isIDValid by remember { mutableStateOf(false) }
        var isPWValid by remember { mutableStateOf(false) }
        var isNameValid by remember { mutableStateOf(false) }
        val context = LocalContext.current

        // Title
        Text(
            text = stringResource(R.string.txt_SignUp_Title),
            modifier = Modifier.padding(10.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        SignUpTextField(
            value = ID,
            onValueChange = { newID ->
                ID = newID
                isIDValid = newID.trim().length in 6..10
            },
            label = stringResource(R.string.tf_SignUp_ID_Hint),
            leadingIcon = Icons.Filled.Person
        )

        SignUpTextField(
            value = PW,
            onValueChange = { newPW ->
                PW = newPW
                isPWValid = newPW.trim().length in 8..12
            },
            label = stringResource(R.string.tf_SignUp_PW_Hint),
            leadingIcon = Icons.Filled.Lock,
            isPassword = true
        )

        SignUpTextField(
            value = Name,
            onValueChange = { newName ->
                Name = newName
                isNameValid = newName.trim().isNotEmpty()
            },
            label = stringResource(R.string.tf_SignUp_Name_Hint),
            leadingIcon = Icons.Filled.Face
        )

        SignUpTextField(
            value = Place,
            onValueChange = { newPlace -> Place = newPlace },
            label = stringResource(R.string.tf_SignUp_Place_Hint),
            leadingIcon = Icons.Filled.Home
        )

        SOPTOutlinedButton(
            R.string.btn_SignUp_SignUp,
            {
                isSignUpValid(
                    navController, context,
                    ID, isIDValid,
                    PW, isPWValid,
                    Name, isNameValid, Place
                )
            },
            true
        )
    }
}
