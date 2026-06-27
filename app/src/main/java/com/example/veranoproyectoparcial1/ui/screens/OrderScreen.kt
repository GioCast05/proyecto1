package com.example.veranoproyectoparcial1.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.veranoproyectoparcial1.viewModel.TaskViewModel

@Composable
fun OrderScreen(navController: NavController, viewModel: TaskViewModel) {
    var Type by remember { mutableStateOf("") }
    var Size by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFFAD1AF)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(60.dp))

            Text(
                text="ORDER",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                fontFamily= FontFamily.Cursive,
                color = Color(0xFF424242),
                letterSpacing = 2.sp
            )
            Spacer(modifier = Modifier.weight(1f))

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    value = Type,
                    onValueChange = { Type = it },
                    label = { Text("Type") },

                )
                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    value = Size,
                    onValueChange = { Size = it },
                    label = { Text("Size") }
                )
                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    value = amount,
                    onValueChange = { amount = it },
                    label = { Text("Amount") }
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        onClick = {  },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFA2A2FF)),
                        shape = RoundedCornerShape(25.dp),
                        modifier = Modifier.size(width = 180.dp, height = 60.dp)
                    ) {
                        Text("SAVE", color = Color.Black, fontWeight = FontWeight.Bold)
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    Button(
                        onClick = { navController.navigate("CustomerScreen")},
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF29681)),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.padding(bottom = 32.dp)
                    ) {
                        Text("EXIT", color = Color.Black, fontWeight = FontWeight.Bold)
                    }
            }

            }

        }

    }
}