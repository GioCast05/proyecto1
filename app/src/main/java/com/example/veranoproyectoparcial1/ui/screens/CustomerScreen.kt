package com.example.veranoproyectoparcial1.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
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
import com.example.veranoproyectoparcial1.ui.theme.btnazul
import com.example.veranoproyectoparcial1.ui.theme.masa
import com.example.veranoproyectoparcial1.viewModel.TaskViewModel

@Composable
fun CustomerScreen(navController: NavController, viewModel: TaskViewModel) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = masa
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(60.dp))


            Text(
                text = "CUSTOMER",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                fontFamily= FontFamily.Cursive,
                color = Color(0xFF424242),
                letterSpacing = 2.sp
            )

            Spacer(modifier = Modifier.weight(1f))


            Button(
                onClick = { navController.navigate("MenuScreen") },
                colors = ButtonDefaults.buttonColors(containerColor = btnazul),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.size(width = 180.dp, height = 60.dp)
            ) {
                Text("MENU", color = Color.Black, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = { navController.navigate("OrderScreen") },
                colors = ButtonDefaults.buttonColors(containerColor = btnazul),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.size(width = 180.dp, height = 60.dp)
            ) {
                Text("ORDER", color = Color.Black, fontWeight = FontWeight.Bold)
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
            Button(onClick = {
                navController.popBackStack()
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
