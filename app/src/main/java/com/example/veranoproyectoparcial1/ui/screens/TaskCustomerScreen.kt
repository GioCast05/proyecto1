package com.example.veranoproyectoparcial1.ui.screens

import androidx.compose.foundation.layout.*
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
import com.example.veranoproyectoparcial1.viewModel.TaskViewModel

@Composable
fun TaskCustomerScreen(viewModel: TaskViewModel) {
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
                text = "CUSTOMER",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                fontFamily= FontFamily.Cursive,
                color = Color(0xFF424242),
                letterSpacing = 2.sp
            )

            Spacer(modifier = Modifier.weight(1f))


            Button(
                onClick = {  },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFA2A2FF)),
                shape = RoundedCornerShape(25.dp),
                modifier = Modifier.size(width = 180.dp, height = 60.dp)
            ) {
                Text("MENU", color = Color.Black, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(40.dp))


            Button(
                onClick = {  },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFA2A2FF)),
                shape = RoundedCornerShape(25.dp),
                modifier = Modifier.size(width = 180.dp, height = 60.dp)
            ) {
                Text("ORDER", color = Color.Black, fontWeight = FontWeight.Bold)
            }

            // Este Spacer empuja los botones hacia el centro desde abajo
            Spacer(modifier = Modifier.weight(1f))


            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF29681)),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.padding(bottom = 32.dp)
            ) {
                Text("EXIT", color = Color.Black, fontWeight = FontWeight.Bold)
            }
        }
    }
}
