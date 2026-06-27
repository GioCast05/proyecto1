package com.example.veranoproyectoparcial1.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
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
fun OrdersScreen(navController: NavController, viewModel: TaskViewModel) {
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
                text = "ORDERS",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Cursive,
                color = Color(0xFF424242),
                letterSpacing = 2.sp
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Lista de órdenes
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(viewModel.orders) { order ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .height(100.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        shape = RoundedCornerShape(4.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = "Type: ${order.type}",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "Size: ${order.size} | Amount: ${order.amount}",
                                    color = Color.Gray,
                                    fontSize = 14.sp
                                )
                            }
                        }
                    }
                }
            }

            // Botón EXIT
            Button(
                onClick = { navController.navigate("CustomerScreen") },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF29681)),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.padding(bottom = 32.dp, top = 16.dp)
            ) {
                Text("EXIT", color = Color.Black, fontWeight = FontWeight.Bold)
            }
        }
    }
}
