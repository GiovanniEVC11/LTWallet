package com.itigevc.ltwallet.ui.screens
/*
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.itigevc.ltwallet.R
import com.itigevc.ltwallet.ui.util.Screens
import com.itigevc.ltwallet.util.firebase.Response
import com.itigevc.ltwallet.viewModel.login.AuthViewModel

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: AuthViewModel
){

    Box(modifier = Modifier.fillMaxSize()){

        Column(
            modifier = Modifier.fillMaxSize()
                .wrapContentHeight()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            val emailState = remember{ mutableStateOf("") }
            val pwdState = remember{ mutableStateOf("") }

            Image(
                painter = painterResource(id = R.drawable.logo_ltwallet),
                contentDescription = "LoginScreen Logo",
                modifier = Modifier.width(250.dp)
                    .padding(top=16.dp)
                    .padding(8.dp)
            )

            Text(
                text= "SignUp",
                modifier = Modifier.padding(18.dp),
                fontSize = 30.sp,
                fontFamily = FontFamily.SansSerif
            )

            OutlinedTextField(
                value = emailState.value,
                onValueChange = {
                    emailState.value = it
            },
                modifier = Modifier.padding(10.dp),
                label = { Text(text = "Enter Your Email") },
                visualTransformation = PasswordVisualTransformation()
            )

            Button(
                onClick = {
                    viewModel.SignIn(
                        email = emailState.value,
                        password = pwdState.value
                    )
                }, modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "Sign In")

                when(val response = viewModel.signInState.value){
                    is Response.Loading -> {
                        CircularProgressIndicator(
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    is Response.Success -> {
                        if(response.data){
                            navController.navigate(Screens.OnBoarding.route){
                                popUpTo(Screens.Login.route){
                                    inclusive = true
                                }
                            }
                        }else {
                            Toast(message = "Sign In failed")
                        }
                    }
                    is Response.Error -> {
                        Toast(message = response.message)
                    }
                }

                Text(text = "New User? Sign Up", color = Color.Blue,
                    modifier = Modifier.padding(8.dp).clickable {
                        navController.navigate(route = Screens.SignUp.route){
                            launchSingleTop = true
                        }
                    }
                )

            }

        }
    }


}

@Composable
fun Toast(message: String){
    makeText(LocalContext.current, message, Toast.LENGTH_SHORT).show()
}

 */