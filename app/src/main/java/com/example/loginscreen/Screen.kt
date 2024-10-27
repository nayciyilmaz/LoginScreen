package com.example.loginscreen

sealed class Screen(val route: String) {
    data object MainScreen : Screen("main_screen")
    data object  SignInScreen : Screen("signIn_screen")
    data object  SignUpScreen : Screen("signUp_screen")
    data object  HomepageScreen : Screen("homepage_screen")

}