package com.example.veranoproyectoparcial1.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Save
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
import com.example.veranoproyectoparcial1.ui.theme.FondoPizzeria
import com.example.veranoproyectoparcial1.ui.theme.OlivaGreen
import com.example.veranoproyectoparcial1.ui.theme.btnazul
import com.example.veranoproyectoparcial1.ui.theme.leafGreen
import com.example.veranoproyectoparcial1.ui.theme.masa
import com.example.veranoproyectoparcial1.ui.theme.peperoni
import com.example.veranoproyectoparcial1.viewModel.OrdersViewModel

@Composable
fun OrderScreen(navController: NavController, ordersViewModel: OrdersViewModel) {
    var Type by remember { mutableStateOf("") }
    var Size by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = masa
    ) {
        Box(
            modifier = Modifier.fillMaxSize().background(FondoPizzeria)
        ){
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
                    color = OlivaGreen,
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
                            ordersViewModel.addOrder(Type, Size, amount)
                            navController.navigate("OrdersScreen")
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = leafGreen),
                    shape = RoundedCornerShape(25.dp),
                    modifier = Modifier.size(width = 180.dp, height = 60.dp)
                ) {
                    Icon(imageVector = Icons.Default.Save, contentDescription = null)
                    Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
                    Text("SAVE", color = Color.Black, fontWeight = FontWeight.Bold)
                }

                Spacer(modifier = Modifier.height(24.dp))
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.End
            ) {
                Button(
                    onClick = {
                        navController.popBackStack()
                    },
                    colors = ButtonDefaults.buttonColors(peperoni),
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
}
