package com.itigevc.ltwallet.view.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.itigevc.ltwallet.R
import com.itigevc.ltwallet.databinding.LaFragmentLoginBinding
import com.itigevc.ltwallet.ui.theme.LTWalletTheme
import com.itigevc.ltwallet.util.listener.OnFragmentActionsListener
// import com.itigevc.ltwallet.viewModel.login.AuthViewModel

class LoginLaFragment : Fragment(R.layout.la_fragment_login) {

    private var listener: OnFragmentActionsListener? = null

    // private var dataBundle: HashMap<String, Any>? = null

    private var _binding: LaFragmentLoginBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LaFragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root

       // val dataFragment=arguments?.get

        // val authViewModel: AuthViewModel by viewModels()

        // listener?.onClickFragmentButton()

        binding.composeViewLogin.apply {
            // Dispose of the Composition when the view's LifecycleOwner is destroyed
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                // In Compose world
                LTWalletTheme {
                    ComposeViewLogin()
                }
            }
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentActionsListener) {
            listener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    @Composable
    private fun ComposeViewLogin(
        //viewModel: AuthViewModel
    ) {

        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.fillMaxSize()
                    .wrapContentHeight().verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                val emailState = remember { mutableStateOf("") }
                val passwordState = remember { mutableStateOf("") }

                HeadLogin()
                FormLogin(emailState, passwordState)
                BtnLogin(emailState, passwordState)
                ChangeToSignUp()

            }
        }

    }

    @Composable
    private fun BtnLogin(
       // viewModel: AuthViewModel,
        emailState: MutableState<String>,
        passwordState: MutableState<String>
    ) {
        Button(
            onClick = {
               // viewModel.SignIn(email = emailState.value, password = pwdState.value)
            }, modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "Sign In")
            /*
            when (val response = viewModel.signInState.value) {
                is Response.Loading -> {
                    CircularProgressIndicator(modifier = Modifier.fillMaxSize())
                }
                is Response.Success -> {
                    if (response.data) {
                        /*navController.navigate(Screens.OnBoarding.route){
                            popUpTo(Screens.Login.route){
                                inclusive = true
                            }
                        } */
                    } else { Toast(message = "Sign In failed") }
                }
                is Response.Error -> { Toast(message = response.message) }
            }

             */
        }

    }

    @Composable
    private fun FormLogin(
        emailState: MutableState<String>,
        passwordState: MutableState<String>,
    ) {

        OutlinedTextField(
            value = emailState.value,
            onValueChange = { emailState.value = it }
        )

        OutlinedTextField(
            value = passwordState.value,
            onValueChange = { passwordState.value = it },
            modifier = Modifier.padding(10.dp),
            label = { Text(text = "Enter Your Password") },
            visualTransformation = PasswordVisualTransformation()
        )

    }

    @Composable
    private fun HeadLogin() {
        Image(
            painter = painterResource(id = R.drawable.logo_ltwallet),
            contentDescription = "LoginScreen Logo",
            modifier = Modifier.width(250.dp)
                .padding(top=16.dp).padding(8.dp)
        )
        Text(
            text= "SignUp",
            modifier = Modifier.padding(18.dp),
            fontSize = 30.sp,
            fontFamily = FontFamily.SansSerif
        )
    }

    @Composable
    private fun ChangeToSignUp(){

        Text(text = "New User? Sign Up", color = Color.Blue,
            modifier = Modifier.padding(8.dp).clickable {

                /*
                    navController.navigate(route = Screens.SignUp.route){
                        launchSingleTop = true
                    }
                */

            }
        )

    }

}