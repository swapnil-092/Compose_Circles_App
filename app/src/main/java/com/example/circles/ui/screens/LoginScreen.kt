package com.example.circles.ui.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.circles.R
import com.example.circles.ui.common.CommonGoogleButton
import com.example.circles.ui.common.CommonLoginButton
import com.example.circles.ui.common.CommonText
import com.example.circles.ui.common.CommonTextField
import com.example.circles.ui.theme.LightGrayColor
import com.example.circles.ui.theme.PinkColor

@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 30.dp, end = 30.dp, top = 20.dp, bottom = 20.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                CommonText(text = "Welcome,", fontSize = 34.sp, fontWeight = FontWeight.Bold) {}
                Spacer(modifier = Modifier.height(5.dp))
                CommonText(
                    text = "Sign in to continue!",
                    fontSize = 28.sp,
                    color = LightGrayColor
                ) {}
            }
            Box(
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.login),
                    contentDescription = "background",
                    modifier = Modifier.fillMaxSize(0.5f),
                    contentScale = ContentScale.FillWidth,
                )
            }
            CommonTextField(
                text = email,
                placeholder = "Email",
                onValueChange = { email = it },
                isPasswordTextField = false
            )
            Spacer(modifier = Modifier.height(16.dp))
            CommonTextField(
                text = password,
                placeholder = "Password",
                onValueChange = { password = it },
                isPasswordTextField = true
            )

            CommonLoginButton(text = "Login", modifier = Modifier.fillMaxWidth().padding(7.dp)) {
                if (email == "adem" && password == "12345") {
                    println("Giris basarili.")
                } else {
                    println("Giris basarisiz.")
                }
                navController.navigate("home_screen")

            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                CommonText(text = "I'm a new user,", fontSize = 18.sp) {}
                Spacer(modifier = Modifier.width(4.dp))
                CommonText(
                    text = "Sign Up",
                    color = Color(0xFF00316E),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W500
                ) {
                    navController.navigate("register_screen")
                }
            }
        }
    }
}