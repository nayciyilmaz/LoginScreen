package com.example.loginscreen

import android.app.AlertDialog
import android.content.DialogInterface
import android.util.Patterns
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(route = Screen.SignInScreen.route) {
            SignInScrenn(navController = navController)
        }
        composable(route = Screen.SignUpScreen.route) {
            SignUpScrenn(navController = navController)
        }
        composable(route = Screen.HomepageScreen.route) {
            HomepageScreen(navController = navController)
        }
    }
}

@Composable
fun MainScreen(navController: NavController, modifier: Modifier = Modifier) {

    BackHandler {
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.login), contentDescription = null)

        Spacer(modifier.height(30.dp))

        Button(
            onClick = {
                navController.navigate(Screen.SignInScreen.route)
            },
            modifier.width(150.dp),
            shape = RectangleShape,
        ) {
            Text(text = stringResource(id = R.string.sign_in_button))
        }
        Button(
            onClick = {
                navController.navigate(Screen.SignUpScreen.route)
            },
            modifier.width(150.dp),
            shape = RectangleShape,
        ) {
            Text(text = stringResource(id = R.string.sign_up_button))
        }
    }
}

@Composable
fun SignInScrenn(navController: NavController, modifier: Modifier = Modifier) {
    var inputMail by remember { mutableStateOf("") }
    var inputPassword by remember { mutableStateOf("") }
    var isErrorInPassword by remember { mutableStateOf(false) }
    var isErrorInEmail by remember { mutableStateOf(false) }

    Text(
        text = stringResource(id = R.string.sign_in_title),
        modifier.padding(start = 28.dp, top = 28.dp, end = 172.dp),
        style = MaterialTheme.typography.titleLarge
    )
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EditText.EditTextField(
            value = inputMail,
            onValueChange = {
                inputMail = it
                isErrorInEmail = Patterns.EMAIL_ADDRESS.matcher(inputMail).matches().not()
            },
            label = R.string.email,
            KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next,
            ),
            supportingText = if (isErrorInEmail) {
                R.string.mail_error
            } else {
                null
            }
        )

        Spacer(modifier.height(30.dp))

        EditText.EditTextField(
            value = inputPassword,
            onValueChange = {
                inputPassword = it
                isErrorInPassword = inputPassword.length < 6
            },
            R.string.password,
            KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.NumberPassword,
                imeAction = ImeAction.Done,
            ),
            visualTransformation = PasswordVisualTransformation(),
            supportingText = if (isErrorInPassword) {
                R.string.password_error
            } else {
                null
            }
        )

        Spacer(modifier.height(30.dp))

        Button(
            onClick = {
                navController.navigate(Screen.HomepageScreen.route)
            },
            shape = RectangleShape,
            enabled = (!isErrorInEmail && !isErrorInPassword &&
                    inputMail.isNotBlank() && inputPassword.isNotBlank()),
            colors = ButtonDefaults.buttonColors(
                disabledContainerColor = Color(0x0F807F7F),
                contentColor = Color(0xFFDADFDE)
            )
        ) {
            Text(text = stringResource(id = R.string.Continue))
        }
    }
}

@Composable
fun SignUpScrenn(navController: NavController, modifier: Modifier = Modifier) {
    var inputName by remember { mutableStateOf("") }
    var inputMail by remember { mutableStateOf("") }
    var inputPassword by remember { mutableStateOf("") }
    var isErrorInName by remember { mutableStateOf(false) }
    var isErrorInPassword by remember { mutableStateOf(false) }
    var isErrorInEmail by remember { mutableStateOf(false) }

    Text(
        text = stringResource(id = R.string.sign_up_title),
        modifier.padding(start = 28.dp, top = 28.dp, end = 172.dp),
        style = MaterialTheme.typography.titleLarge
    )
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EditText.EditTextField(
            value = inputName,
            onValueChange = {
                inputName = it
                isErrorInName = inputName.length < 3
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next,
            ),
            label = R.string.name,
            supportingText = if (isErrorInName) {
                R.string.name_error
            } else {
                null
            }
        )

        Spacer(modifier.height(12.dp))

        EditText.EditTextField(
            value = inputMail,
            onValueChange = {
                inputMail = it
                isErrorInEmail = Patterns.EMAIL_ADDRESS.matcher(inputMail).matches().not()
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next,
            ),
            label = R.string.email,
            supportingText = if (isErrorInEmail) {
                R.string.mail_error
            } else {
                null
            }
        )

        Spacer(modifier.height(12.dp))

        EditText.EditTextField(
            value = inputPassword,
            onValueChange = {
                inputPassword = it
                isErrorInPassword = inputPassword.length < 6
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.NumberPassword,
                imeAction = ImeAction.Done,
            ),
            label = R.string.password,
            visualTransformation = PasswordVisualTransformation(),
            supportingText = if (isErrorInPassword) {
                R.string.password_error
            } else {
                null
            }
        )

        Spacer(modifier.height(30.dp))

        Button(
            onClick = {
                navController.navigate(Screen.HomepageScreen.route)
            },
            shape = RectangleShape,
            enabled = !isErrorInName && !isErrorInEmail && !isErrorInPassword
                    && inputName.isNotBlank() && inputMail.isNotBlank() && inputPassword.isNotBlank(),
            colors = ButtonDefaults.buttonColors(
                disabledContainerColor = Color(0x0F807F7F),
                contentColor = Color(0xFFDADFDE)
            )
        )
        {
            Text(text = stringResource(id = R.string.Continue))
        }
    }
}

@Composable
fun HomepageScreen(navController: NavController, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    BackHandler {
        val alertDialog = AlertDialog.Builder(context)
        alertDialog.setTitle(R.string.log_out)
        alertDialog.setMessage(R.string.log_out_message)

        alertDialog.setPositiveButton(R.string.yes) { _, _ ->
            navController.navigate(Screen.MainScreen.route)
        }
        alertDialog.setNegativeButton(R.string.no, null)
        alertDialog.show()
    }

    Text(
        text = stringResource(id = R.string.homepage_title),
        modifier.padding(start = 28.dp, top = 28.dp, end = 172.dp),
        style = MaterialTheme.typography.titleLarge
    )
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.homepage), contentDescription = null)

        Spacer(modifier.height(30.dp))

        Button(
            onClick = {
                val alertDialog = AlertDialog.Builder(context)
                alertDialog.setTitle(R.string.log_out)
                alertDialog.setMessage(R.string.log_out_message)
                
                alertDialog.setPositiveButton(R.string.yes) { _, _ ->
                    navController.navigate(Screen.MainScreen.route)
                }
                alertDialog.setNegativeButton(R.string.no, null)
                alertDialog.show()
            },
            shape = RectangleShape
        )
        {
            Text(text = stringResource(id = R.string.log_out))
        }
    }
}