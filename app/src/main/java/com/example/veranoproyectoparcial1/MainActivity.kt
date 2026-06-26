package com.example.veranoproyectoparcial1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.veranoproyectoparcial1.navigation.NavGraph
import com.example.veranoproyectoparcial1.ui.screens.TaskCustomerScreen
import com.example.veranoproyectoparcial1.ui.theme.VeranoProyectoParcial1Theme
import com.example.veranoproyectoparcial1.viewModel.TaskViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VeranoProyectoParcial1Theme {
                val taskViewModel = TaskViewModel()
                TaskCustomerScreen(viewModel = taskViewModel)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VeranoProyectoParcial1Theme {
        Greeting("Android")
    }
}