package com.itigevc.ltwallet.view.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.itigevc.ltwallet.R
import com.itigevc.ltwallet.databinding.LaFragmentSignupBinding
//import com.itigevc.ltwallet.ui.screens.Toast
import com.itigevc.ltwallet.ui.theme.LTWalletTheme

//import com.itigevc.ltwallet.viewModel.login.AuthViewModel

class SignUpLaFragment : Fragment(R.layout.la_fragment_signup) {

    private var _binding: LaFragmentSignupBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LaFragmentSignupBinding.inflate(inflater, container, false)
        val view = binding.root

        //val authViewModel: AuthViewModel by viewModels()

        binding.composeViewSignUp.apply {
            // Dispose of the Composition when the view's LifecycleOwner is destroyed
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                // In Compose world
                LTWalletTheme {
                    SignUpCompose()
                }
            }
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @Composable
    fun SignUpCompose(
        //viewModel: AuthViewModel
    ){

        Box(modifier = Modifier.fillMaxSize()){

            Column(
                modifier = Modifier.fillMaxSize()
                    .wrapContentHeight()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally)
            {

                val userNameState = remember{ mutableStateOf("") }
                val emailState = remember{ mutableStateOf("") }
                val passwordState = remember{ mutableStateOf("") }

                TitleCompose()

                FormCompose(userNameState, emailState, passwordState)

                Button(
                    onClick = {
                       /* viewModel.SignUp(
                            email = emailState.value, password = passwordState.value
                        )

                        */
                    }, modifier = Modifier.padding(8.dp)
                ){
                    Text(text = "Sign In")
                    /*
                    when(val response = viewModel.signInState.value){
                        is Response.Loading -> {
                            CircularProgressIndicator(
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                        is Response.Success -> {
                            if(response.data){
                                /*
                                navController.navigate(Screens.OnBoarding.route){
                                    popUpTo(Screens.Login.route){
                                        inclusive = true
                                    }
                                }
                                 */

                            }else {
                                Toast(message = "Sign In failed")
                            }
                        }
                        is Response.Error -> {
                            Toast(message = response.message)
                        }
                    }

                     */
                    SignInText()
                }

            }
        }

    }

    @Composable
    fun TitleCompose(){

        Image(
            painter = painterResource(id = R.drawable.logo_ltwallet),
            contentDescription = "LoginScreen Logo",
            modifier = Modifier.width(250.dp).padding(top = 16.dp).padding(8.dp)
        )
        /*
        Text(
            text= AnnotatedString("Sign Up"),
            modifer = Modifier.padding(18.dp),
            fontSize = 30.sp,
            fontFamily = FontFamily.SansSerif
        )
         */
    }

    @Composable
    fun FormCompose (
        userNameState: MutableState<String>,
        emailState: MutableState<String>,
        passwordState: MutableState<String>
    ){

        OutlinedTextField(
            value = userNameState.value,
            label = { Text(text = "Enter your UserName") },
            onValueChange = { userNameState.value = it }
        )

        OutlinedTextField(
            value = emailState.value,
            label = { Text(text = "Enter your Email") },
            onValueChange = { emailState.value = it }
        )

        OutlinedTextField(
            value = passwordState.value,
            label = { Text(text = "Enter your Password") },
            onValueChange = { passwordState.value = it },
            visualTransformation = PasswordVisualTransformation()
        )

    }

    @Composable
    fun SignInText(
       // navController: NavController
    ) {
        ClickableText(
            text = AnnotatedString("Already a User? Sign In"),
            modifier = Modifier.padding(8.dp),
            onClick = {  /*
                offset ->

                navController.navigate(route = Screens.Login.route){
                    launchSingleTop = true
                }
          */
            }
        )
    }


}