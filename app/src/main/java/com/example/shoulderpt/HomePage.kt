package com.example.shoulderpt

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomePage(navController: NavController, viewModel: ExerciseViewModel) {

    val selectedOption = viewModel.selectedOption.value
    val options = viewModel.options// Observe the selected option


    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navController.navigate("Welcome") }) {
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
        "Pendulum Swing",
        "Posterior Stretching",
        "Up The Back Stretch",
        "Overhead Stretch",
        "Shoulder Flexion",
        "Shoulder Rotation",
        "Wall Climbing Side",
        "Wall Climbing Front",
        "Shoulder Blade Squeeze",
        "Scapular Arm Reach",
        "Arm Raise Side",
        "Shoulder Flexor and Extensor",
        "Scapular Wall Push-Up",
        "Scapular Retraction",
        "Internal Rotator",
        "External Rotator"
    )

    val exerciseToRouteMap = mapOf(
        "Pendulum Swing" to "pendulumSwing",
        "Posterior Stretching" to "posteriorStretching",
        "Up The Back Stretch" to "upTheBackStretch",
        "Overhead Stretch" to "overheadStretch",
        "Shoulder Flexion" to "shoulderFlexion",
        "Shoulder Rotation" to "shoulderRotation",
        "Wall Climbing Side" to "wallClimbingSide",
        "Wall Climbing Front" to "wallClimbingFront",
        "Shoulder Blade Squeeze" to "shoulderBladeSqueeze",
        "Scapular Arm Reach" to "scapularArmReach",
        "Arm Raise Side" to "armRaiseSide",
        "Shoulder Flexor and Extensor" to "shoulderFlexorAndExtensor",
        "Scapular Wall Push-Up" to "scapularWallPushUp",
        "Scapular Retraction" to "scapularRetraction",
        "Internal Rotator" to "internalRotator",
        "External Rotator" to "externalRotator"
    )

    @Composable
    fun getImageResourceForExercise(exerciseName: String): Int {
        return when (exerciseName) {
            "Pendulum Swing" -> R.drawable.pendulumswing // Replace with actual image name
            "Posterior Stretching" -> R.drawable.posteriorstretching // Replace with actual image
            "Up The Back Stretch" -> R.drawable.upthebackstretch // Replace with actual image name
            "Overhead Stretch" -> R.drawable.overtheheadstretch// Replace with actual image name
            "Shoulder Flexion" -> R.drawable.shoulderflexion // Replace with actual image name
            "Shoulder Rotation" -> R.drawable.shoulderrotation // Replace with actual image name
            "Wall Climbing Side" -> R.drawable.wallclimbingside // Replace with actual image name
            "Wall Climbing Front" -> R.drawable.wallclimbingfront // Replace with actual image name
            "Shoulder Blade Squeeze" -> R.drawable.shoulderbladesqueeze // Replace with actual image name
            "Scapular Arm Reach" -> R.drawable.scapulararmreach // Replace with actual image name
            "Arm Raise Side" -> R.drawable.armraiseside // Replace with actual image name
            "Shoulder Flexor and Extensor" -> R.drawable.shoulderflexorandextensor // Replace with actual image name
            "Scapular Wall Push-Up" -> R.drawable.wallpushup // Replace with actual image name
            "Scapular Retraction" -> R.drawable.scapularretractionpulley // Replace with actual image name
            "Internal Rotator" -> R.drawable.internalrotator // Replace with actual image name
            "External Rotator" -> R.drawable.externalrotator // Replace with actual image name
            else -> R.drawable.shoulderpain // Default image if no match is found
        }
    }

    LazyVerticalGrid(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(vertical = 16.dp),
        columns = GridCells.Fixed(2)
    ) {
        items(items = exerciseList) { name ->
            val imageResource = getImageResourceForExercise(name)
            Card(
                shape = RoundedCornerShape(4.dp), // Defines the shape of the Card
                border = BorderStroke(2.dp, Color.Black),
                modifier = Modifier
                    .padding(10.dp)
                    .size(150.dp)
                    .clickable {
                        exerciseToRouteMap[name]?.let { route ->
                            navController.navigate(route)
                        }
                    },
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                )
            ) {
                Image(
                    painter = painterResource(id = imageResource),
                    contentDescription = name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize() // Fill the Card
                        .clip(RoundedCornerShape(4.dp)) // Clip the Image
                )
            }
        }
    }
}

/*@Composable
fun mockNavController() = rememberNavController()

@Preview(showBackground = true)
@Composable
fun DefaultPreviewHomePage() {
    HomePage(navController = mockNavController())
} */

