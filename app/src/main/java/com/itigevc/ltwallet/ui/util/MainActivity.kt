package com.itigevc.ltwallet.ui.util

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHost
/*
import com.itigevc.ltwallet.ui.SplashScreen
import com.itigevc.ltwallet.ui.screens.FeedsScreen
import com.itigevc.ltwallet.ui.screens.LoginScreen
import com.itigevc.ltwallet.ui.screens.SignUpScreen
import com.itigevc.ltwallet.ui.theme.LTWalletTheme
import com.itigevc.ltwallet.util.Screens
import com.itigevc.ltwallet.viewModel.login.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint
 */
/*
//@AndroidEntryPoint
class MainActivity : ComponentActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LTWalletTheme {
                Surface(color= MaterialTheme.colors.background) {
                    //val navController = rememberNavController()
                    //val authViewModel : AuthViewModel by viewModels()

                    //LTWalletApp(navController, authViewModel = authViewModel)
                }
            }
        }


    }
}

 */

/*
@Composable
fun LTWalletApp(
    navController: NavController,
    authViewModel: AuthViewModel)
{

    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    ){

        composable(route = Screens.Login.route){
            LoginScreen(navController, authViewModel)
        }

        composable(route = Screens.SignUp.route){
            SignUpScreen(navController, authViewModel)
        }

        composable(route = Screens.Feed.route){
            FeedsScreen(navController, authViewModel)
        }

        composable(route = Screens.Profile.route){
            SplashScreen(navController, authViewModel)
        }

    }
}

 */
