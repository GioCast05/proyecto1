package com.example.veranoproyectoparcial1.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.veranoproyectoparcial1.model.pizzaMenu
import com.example.veranoproyectoparcial1.ui.theme.FondoPizzeria
import com.example.veranoproyectoparcial1.ui.theme.OlivaGreen
import com.example.veranoproyectoparcial1.ui.theme.peperoni


@Composable
fun MenuScreen(navController: NavController) {
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
                    .padding(top = 70.dp, start = 28.dp, end = 28.dp, bottom = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "ORDERS",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Black,
                    color = OlivaGreen,
                    fontFamily = FontFamily.Cursive
                )

                Spacer(modifier = Modifier.height(40.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(410.dp)
                        .background(Color.White),
                ) {
                    Column(
                        modifier = Modifier.padding(10.dp)
                    ) {
                        pizzaMenu.forEach { pizza ->
                            Text(
                                "${pizza.name}.......  $${pizza.priceSmall}CH     $${pizza.priceLarge}G",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(24.dp))
                        }
                    }
                }

                Spacer(modifier = Modifier.weight(1f))

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