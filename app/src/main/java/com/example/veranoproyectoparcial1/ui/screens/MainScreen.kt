package com.example.veranoproyectoparcial1.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Assignment
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
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
import androidx.navigation.NavHostController
import com.example.veranoproyectoparcial1.ui.theme.FondoPizzeria
import com.example.veranoproyectoparcial1.ui.theme.OlivaGreen
import com.example.veranoproyectoparcial1.ui.theme.cheese
import com.example.veranoproyectoparcial1.ui.theme.leafGreen
import com.example.veranoproyectoparcial1.ui.theme.peperoni

@Composable
fun MainScreen(navController: NavHostController){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Transparent
    ){
        Box(
            modifier = Modifier.fillMaxSize().background(FondoPizzeria)
        ) {
            Spacer(modifier = Modifier.height(80.dp))

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Menu Principal",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Black,
                    fontFamily = FontFamily.Cursive,
                    color = OlivaGreen
                )

                Spacer(modifier = Modifier.height(100.dp))

                Button(
                    onClick = { navController.navigate("OrdersScreen") },
                    colors = ButtonDefaults.buttonColors(containerColor = cheese),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.size(width = 180.dp, height = 60.dp)
                ) {
                    Icon(imageVector = Icons.Default.Assignment, contentDescription = null)
                    Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
                    Text("Employer")
                }

                Spacer(modifier = Modifier.height(60.dp))

                Button(
                    onClick = { navController.navigate("CustomerScreen") },
                    colors = ButtonDefaults.buttonColors(containerColor = cheese),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.size(width = 180.dp, height = 60.dp)
                ) {
                    Icon(imageVector = Icons.Default.Person, contentDescription = null)
                    Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
                    Text("Customer")
                }

                Spacer(modifier = Modifier.height(60.dp))

                Button(
                    onClick = { navController.navigate("UsScreen") },
                    colors = ButtonDefaults.buttonColors(containerColor = leafGreen),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.size(width = 150.dp, height = 40.dp)
                ) {
                    Icon(imageVector = Icons.Default.Info, contentDescription = null)
                    Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
                    Text("Nosotros")
                }

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