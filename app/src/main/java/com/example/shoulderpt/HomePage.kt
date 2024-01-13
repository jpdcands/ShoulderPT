package com.example.shoulderpt


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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

    @Composable
    fun getImageResourceForExercise(exerciseName: String): Int {
        return when (exerciseName) {
            "Pendulum" -> R.drawable.pendulum // Replace with actual image name
            "Posterior Stretching" -> R.drawable.posteriorstretching // Replace with actual image name
            "Up-the-back Stretch" -> R.drawable.upthebackstretch // Replace with actual image name
            "Overhead Stretch" -> R.drawable.overtheheadstretch// Replace with actual image name
            "Shoulder Flexor" -> R.drawable.shoulderflexordown // Replace with actual image name
            "Shoulder Rotation" -> R.drawable.shoulderrotation // Replace with actual image name
            "Wall Climber-Side" -> R.drawable.wallclimberside // Replace with actual image name
            "Wall Climber-Front" -> R.drawable.wallclimberfront // Replace with actual image name
            "Shoulder Blade Squeeze" -> R.drawable.shoulderbladesqueeze // Replace with actual image name
            //    "Arm Reach-Front" -> R.drawable.exercise2_image // Replace with actual image name
            //    "Arm Reach-Side" -> R.drawable._image // Replace with actual image name
            "Arm Raise-Side" -> R.drawable.armraiseside // Replace with actual image name
            "Shoulder Flexor and Extensor" -> R.drawable.shoulderflexorandextensor // Replace with actual image name
            "Wall Push-Up" -> R.drawable.wallpushup // Replace with actual image name
            "Scapular Retraction-1" -> R.drawable.scapularretraction // Replace with actual image name
            "Scapular Retraction-2" -> R.drawable.scapularretractieontwo // Replace with actual image name
            "Internal Rotator" -> R.drawable.internalrotation // Replace with actual image name
            "External Rotator" -> R.drawable.externalrotation // Replace with actual image name
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
              //  elevation = 8.dp,
                modifier = Modifier
                    .padding(12.dp)
                    .size(150.dp)
                    .clickable {
                        exerciseToRouteMap[name]?.let { route ->
                            navController.navigate(route)
                        }
                    },
            ) {
                Image(
                    painter = painterResource(id = imageResource),
                    contentDescription = name,
                    modifier = Modifier
                        .fillMaxSize() // Fill the Card
                        .clip(RoundedCornerShape(4.dp)) // Clip the Image
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewHomePage() {
    val navController = rememberNavController()
    HomePage(navController)
    NamesLazyColumn(navController)
}

