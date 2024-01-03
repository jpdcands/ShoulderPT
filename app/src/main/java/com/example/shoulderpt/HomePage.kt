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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomePage(navController: NavController) {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navController.navigate("landingPage") }) {
                Text("Back to Welcome Page", fontSize = 20.sp)
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
        "Arm Reach-Front",
        "Arm Reach-Side",
        "Arm Raise-Side",
        "Shoulder Flexor and Extensor",
        "Wall Push-Up",
        "Scapular Retraction",
        "Internal Rotator",
        "External Rotator"
    )

    val exerciseToRouteMap = mapOf(
        "Pendulum" to "Pendulum",
        "Posterior Stretching" to "posteriorStretching",
        "Up-the-back Stretch" to "upTheBackStretch",
        "Overhead Stretch" to "overheadStretch",
        "Shoulder Flexor" to "shoulderFlexor",
        "Shoulder Rotation" to "shoulderRotation",
        "Wall Climber-Side" to "wallClimberSide",
        "Wall Climber-Front" to "wallClimberFront",
        "Shoulder Blade Squeeze" to "shoulderBladeSqueeze",
        "Arm Reach-Front" to "armReachFront",
        "Arm Reach-Side" to "armReachSide",
        "Arm Raise-Side" to "armRaiseSide",
        "Shoulder Flexor and Extensor" to "shoulderFlexorAndExtensor",
        "Wall Push-Up" to "wallPushUp",
        "Scapular Retraction" to "scapularRetraction",
        "Internal Rotator" to "internalRotator",
        "External Rotator" to "externalRotator"
    )

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(items = exerciseList) { name ->
            Button(
                onClick = {
                    exerciseToRouteMap[name]?.let { route ->
                        navController.navigate(route)
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

@Preview(showBackground = true)
@Composable
fun DefaultPreviewSecondPage() {
    val navController = rememberNavController()
    HomePage(navController)
    NamesLazyColumn(navController)
}

