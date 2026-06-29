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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.veranoproyectoparcial1.ui.theme.OlivaGreen
import com.example.veranoproyectoparcial1.ui.theme.harmony
import com.example.veranoproyectoparcial1.ui.theme.masa
import com.example.veranoproyectoparcial1.ui.theme.peperoni
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import com.example.veranoproyectoparcial1.R
import com.example.veranoproyectoparcial1.ui.theme.FondoPizzaOscuro
import com.example.veranoproyectoparcial1.ui.theme.FondoPizzeria

@Composable
fun UsScreen(navController: NavHostController) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = masa
    ) {
        Box(
            modifier = Modifier.fillMaxSize().background(FondoPizzaOscuro)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),

                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(15.dp))

                // Logo principal
                Image(
                    painter = painterResource(R.drawable.logo_pizzeria),
                    contentDescription = "Logo",
                    modifier = Modifier.size(180.dp),
                    contentScale = ContentScale.Fit
                )

                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = "SOBRE NOSOTROS",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = OlivaGreen
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text =
                        "Este proyecto fue desarrollado como práctica académica " +
                                "para la asignatura de Programación de Dispositivos Móviles, " +
                                "utilizando Kotlin y Jetpack Compose. El objetivo fue aplicar " +
                                "los conocimientos adquiridos durante el curso mediante el " +
                                "desarrollo de una aplicación de gestión para una pizzería, " +
                                "implementando interfaces modernas y una navegación sencilla.",
                    textAlign = TextAlign.Justify,
                    fontSize = 16.sp,
                    color = harmony
                )

                Spacer(modifier = Modifier.height(25.dp))

                Text(
                    text = "Desarrolladores",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = OlivaGreen
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "• Karen Sarai Porras González",
                    fontSize = 18.sp,
                    color = harmony
                )

                Text(
                    text = "• Rodrigo de Jesús Hernández Aguilar",
                    fontSize = 18.sp,
                    color = harmony
                )

                Spacer(modifier = Modifier.weight(1f))

                // Logos institucionales
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {

                    Image(
                        painter = painterResource(R.drawable.itspr_logo),
                        contentDescription = "ITSPR",
                        modifier = Modifier.size(90.dp)
                    )

                    Image(
                        painter = painterResource(R.drawable.tecnm_logo),
                        contentDescription = "TECNM",
                        modifier = Modifier.size(90.dp)
                    )

                }

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = { navController.popBackStack() },
                    colors = ButtonDefaults.buttonColors(peperoni),
                    shape = RoundedCornerShape(8.dp)
                ) {

                    Icon(
                        imageVector = Icons.Default.ExitToApp,
                        contentDescription = null
                    )

                    Text(" Exit")
                }

            }
        }

    }

}