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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import com.example.veranoproyectoparcial1.model.calculatePrice
import com.example.veranoproyectoparcial1.model.pizzaMenu
import com.example.veranoproyectoparcial1.ui.theme.FondoPizzeria
import com.example.veranoproyectoparcial1.ui.theme.OlivaGreen
import com.example.veranoproyectoparcial1.ui.theme.leafGreen
import com.example.veranoproyectoparcial1.ui.theme.peperoni
import com.example.veranoproyectoparcial1.viewModel.OrdersViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderScreen(navController: NavController, ordersViewModel: OrdersViewModel) {
    val context = LocalContext.current
    var type by remember { mutableStateOf("") }
    var size by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("1") }

    var expandedType by remember { mutableStateOf(false) }
    var expandedSize by remember { mutableStateOf(false) }

    val sizes = listOf("Chica", "Grande")

    val currentPrice = remember(type, size, amount) {
        val amt = amount.toIntOrNull() ?: 0
        calculatePrice(type, size, amt)
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Transparent
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

                Spacer(modifier = Modifier.height(80.dp))

                // Formulario
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Spacer(modifier = Modifier.height(25.dp))

                    ExposedDropdownMenuBox(
                        expanded = expandedType,
                        onExpandedChange = { expandedType = !expandedType }
                    ) {
                        TextField(
                            value = type,
                            onValueChange = {},
                            readOnly = true,
                            label = { Text("Pizza") },
                            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedType) },
                            modifier = Modifier.menuAnchor().fillMaxWidth(0.8f)
                        )
                        ExposedDropdownMenu(
                            expanded = expandedType,
                            onDismissRequest = { expandedType = false }
                        ) {
                            pizzaMenu.forEach { pizza ->
                                DropdownMenuItem(
                                    text = { Text(pizza.name) },
                                    onClick = {
                                        type = pizza.name
                                        expandedType = false
                                    }
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(25.dp))

                    ExposedDropdownMenuBox(
                        expanded = expandedSize,
                        onExpandedChange = { expandedSize = !expandedSize }
                    ) {
                        TextField(
                            value = size,
                            onValueChange = {},
                            readOnly = true,
                            label = { Text("Size") },
                            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedSize) },
                            modifier = Modifier.menuAnchor().fillMaxWidth(0.8f)
                        )
                        ExposedDropdownMenu(
                            expanded = expandedSize,
                            onDismissRequest = { expandedSize = false }
                        ) {
                            sizes.forEach { selectionSize ->
                                DropdownMenuItem(
                                    text = { Text(selectionSize) },
                                    onClick = {
                                        size = selectionSize
                                        expandedSize = false
                                    }
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(25.dp))

                    TextField(
                        value = amount,
                        onValueChange = { amount = it },
                        label = { Text("Amount") },
                        modifier = Modifier.fillMaxWidth(0.8f)
                    )

                    // Mostrar Precio Automáticamente
                    if (currentPrice > 0) {
                        Text(
                            text = "Total Price: $$currentPrice",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }
                }

                Spacer(modifier = Modifier.height(90.dp))

                Button(
                    onClick = {
                        if (type.isNotBlank() && size.isNotBlank() && amount.isNotBlank() && currentPrice!=0) {
                            ordersViewModel.addOrder(type, size, amount, currentPrice)
                            Toast.makeText(context, "Orden agregada", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(context, "Datos faltantes", Toast.LENGTH_SHORT).show()
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = leafGreen),
                    shape = RoundedCornerShape(10.dp),
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
                    shape = RoundedCornerShape(10.dp),
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
