package com.example.shoulderpt

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
@Composable
fun ImageSectionScapularWallPushUp() {
    Image(
        painter = painterResource(id = R.drawable.wallpushup),
        contentDescription = "Scapular Wall Push Up",
        modifier = Modifier.size(250.dp)
    )
}

@Composable
fun InstructionsTextScapularWallPushUp() {
    val text = """
        1. This exercise does not use the arm muscles - use your legs and hips to create movement.
        2. Swing arm back and forth like a pendulum then use your hips to make circles
        3. Do this exercise for 5 minutes 4 times a day.
        4. As pain decreases, try bending over further.
    """.trimIndent()

    Text(
        text = text,
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    )
}

@Composable
fun RadioButtonsSectionScapularWallPushUp(navController: NavController, viewModel: ExerciseViewModel) {
    val selectedOption = viewModel.selectedOption.value
    val options = viewModel.options

    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        options.forEach { option ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(text = option, textAlign = TextAlign.Center)
                RadioButton(
                    selected = selectedOption == option,
                    onClick = { viewModel.updateSelectedOption(option) }
                )
            }
        }
    }
}

@Composable
fun NextExerciseButtonScapularWallPushUp(navController: NavController) {
    Button(onClick = { navController.navigate("ScapularRetraction") }) {
        Text("To Next Exercise", fontSize = 20.sp)
    }
}

@Composable
fun BackToExerciseListScapularWallPushUp(navController: NavController) {
    Button(onClick = { navController.navigate("HomePage") }) {
        Text("Back to Exercise List", fontSize = 20.sp)
    }
}

@Composable
fun ClearAllSetsButtonScapularWallPushUp(viewModel: ExerciseViewModel) {
    Button(
        onClick = { viewModel.clearSelectedOption() },
        modifier = Modifier.wrapContentSize()
    ) {
        Text("Clear All Sets", fontSize = 20.sp)
    }
}

@Composable
fun ScapularWallPushUp(navController: NavController, viewModel: ExerciseViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Text("Scapular Wall Push Up", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(8.dp))
        ImageSectionScapularWallPushUp()
        InstructionsTextScapularWallPushUp()
        Spacer(modifier = Modifier.height(8.dp)) // Control this value to adjust spacing
        Spacer(modifier = Modifier.height(8.dp))
        RadioButtonsSection(navController, viewModel)
        NextExerciseButtonScapularWallPushUp(navController)
        BackToExerciseListButton(navController)
        ClearAllSetsButtonScapularWallPushUp(viewModel)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewScapularWallPushUp() {
    val navController = rememberNavController()
    PendulumSwing(navController)
}

