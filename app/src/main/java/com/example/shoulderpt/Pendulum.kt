package com.example.shoulderpt

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.rememberNavController

@Composable
fun Pendulum(navController: NavController) {

  //  val navController = rememberNavController()

    var selectedOption by remember { mutableStateOf("Option 1") }
    val options = listOf("Option 1", "Option 2", "Option 3")

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Title", style = MaterialTheme.typography.displayLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable.pendulum), // Replace with your image resource
            contentDescription = "Pendulum"
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text("Some text goes here...")
        Spacer(modifier = Modifier.height(16.dp))

        options.forEach { option ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = option == selectedOption,
                    onClick = { selectedOption = option }
                )
                Text(text = option)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { /* Handle button click */ }) {
            Text("Button 1")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { navController.navigate("secondPage") }) {
            Text("Back to Exercise List", fontSize = 20.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    val navController = rememberNavController()

    Pendulum(navController)
}
