package com.example.veranoproyectoparcial1.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
                text = "ORDER",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Cursive,
                color = Color(0xFF424242),
                letterSpacing = 2.sp
            )

            Spacer(modifier = Modifier.weight(0.5f))

            // Formulario
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                TextField(
                    value = Type,
                    onValueChange = { Type = it },
                    label = { Text("Type") },
                    modifier = Modifier.fillMaxWidth(0.8f)
                )

                TextField(
                    value = Size,
                    onValueChange = { Size = it },
                    label = { Text("Size") },
                    modifier = Modifier.fillMaxWidth(0.8f)
                )

                TextField(
                    value = amount,
                    onValueChange = { amount = it },
                    label = { Text("Amount") },
                    modifier = Modifier.fillMaxWidth(0.8f)
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            // Botón SAVE
            Button(
                onClick = {
                    if (Type.isNotBlank() && Size.isNotBlank() && amount.isNotBlank()) {
                        viewModel.addOrder(Type, Size, amount)
                        navController.navigate("OrdersScreen")
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFA2A2FF)),
                shape = RoundedCornerShape(25.dp),
                modifier = Modifier.size(width = 180.dp, height = 60.dp)
            ) {
                Text("SAVE", color = Color.Black, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Botón EXIT
            Button(
                onClick = { navController.navigate("CustomerScreen") },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF29681)),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.padding(bottom = 32.dp)
            ) {
                Text("EXIT", color = Color.Black, fontWeight = FontWeight.Bold)
            }
        }
    }
}
