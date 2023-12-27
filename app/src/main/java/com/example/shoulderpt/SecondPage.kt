package com.example.shoulderpt


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun SecondPage(navController: NavController) {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navController.navigate("landingPage") }) {
                Text("Back to Landing Page", fontSize = 20.sp)
            }
            Spacer(modifier = Modifier.height(16.dp))
            NamesLazyColumn(navController)
        }
    }
}

@Composable
fun NamesLazyColumn(navController: NavController) {

    val exerciseList = listOf(
        "Pendulum",
        "Posterior Stretching",
        "Up-the-back Stretch",
        "Overhead Stretch",
        "Shoulder Flexor",
        "Shoulder Rotation",
        "Wall Climber-Side",
        "Wall Climber-Front",
        "Shoulder Blade Squeeze",
        "Arm Reach- Front",
        "Arm Reach-Side",
        "Arm Raise-Side",
        "Shoulder Flexor and Extensor",
        "Wall Push-Up",
        "Scapular Retraction",
        "Internal Rotator",
        "External Rotator"
    )

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(items = exerciseList) { name ->
            Button(
                onClick = {
                    if (name == "Pendulum") {
                        navController.navigate("Pendulum")
                    }
                },
                modifier = Modifier
                    .padding(12.dp) // Adjust padding as needed
            ) {
                Text(
                    text = name,
                    modifier = Modifier.padding(8.dp),
                    style = TextStyle(
                        fontSize = 24.sp
                    ),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

