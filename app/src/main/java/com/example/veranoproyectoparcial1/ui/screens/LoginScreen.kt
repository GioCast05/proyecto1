package com.example.veranoproyectoparcial1.ui.screens

import android.app.Activity
import android.widget.Toast
import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.DoorFront
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Login
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.veranoproyectoparcial1.ui.theme.OlivaGreen
import com.example.veranoproyectoparcial1.ui.theme.btnazul
import com.example.veranoproyectoparcial1.ui.theme.masa

@Composable
fun LoginScreen(navController: NavHostController){
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current
    val activity = LocalActivity.current as Activity

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = masa
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            Spacer(modifier = Modifier.height(80.dp))

            Text("BIENVENIDO A",
                fontSize = 30.sp,
                fontWeight = FontWeight.Black,
                fontFamily = FontFamily.Cursive
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text("LA PIZZERIA APP",
                fontSize = 30.sp,
                fontWeight = FontWeight.Black,
                fontFamily = FontFamily.Cursive
            )

            Spacer(modifier = Modifier.height(100.dp))

            Text("Login", fontSize = 30.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(30.dp))

            TextField(
                shape = RoundedCornerShape(12.dp),
                value = username,
                onValueChange = { username = it },
                label = { Text("username") }
            )

            Spacer(modifier = Modifier.height(30.dp))

            TextField(
                shape = RoundedCornerShape(12.dp),
                value = password,
                onValueChange = { password = it },
                label = { Text("password") }
            )

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = {
                    if (username == "admin" && password == "admin") {
                        navController.navigate("MainScreen")
                    } else {
                        Toast.makeText(context, "Usuario o Contraseña Incorrectas", Toast.LENGTH_SHORT).show()
                    }
                },
                shape = RoundedCornerShape(9.dp),
                colors = ButtonDefaults.buttonColors(btnazul),

            ) {
                Icon(
                    imageVector = Icons.Default.Login,
                    contentDescription = "  Login"
                )
                Text("  Login")
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {
            Button(onClick = {
                activity.finish()
            },
                colors = ButtonDefaults.buttonColors(Color.Red),
                shape = RoundedCornerShape(5.dp),
            )
            {
                Icon(
                    imageVector = Icons.Default.ExitToApp,
                    contentDescription = "Salir"
                )
                Text("  Exit")
            }
        }
    }
}