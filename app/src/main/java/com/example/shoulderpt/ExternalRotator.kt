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
fun ImageSectionExternalRotator() {
    Image(
        painter = painterResource(id = R.drawable.externalrotator),
        contentDescription = "External Rotator",
        modifier = Modifier.size(250.dp)
    )
}

@Composable
fun InstructionsTextExternalRotator() {
    val text = """
        1. Tie a band around a wall anchor with elbow bent 90 degrees
        2. With a towel between elbow & body & the bent elbow furthest from anchor
        3. Rotate arm away from anchor until it is 90 degrees in front of body & slowly reverse
        4. Repeat 8-12 times 3 times a day
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
fun RadioButtonsSectionExternalRotator(navController: NavController, viewModel: ExerciseViewModel) {
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
fun NextExerciseButtonExternalRotator(navController: NavController) {
    Button(onClick = { navController.navigate("PendulumSwing") }) {
        Text("To Next Exercise", fontSize = 20.sp)
    }
}

@Composable
fun BackToExerciseListExternalRotator(navController: NavController) {
    Button(onClick = { navController.navigate("HomePage") }) {
        Text("Back to Exercise List", fontSize = 20.sp)
    }
}

@Composable
fun ClearAllSetsButtonExternalRotator(viewModel: ExerciseViewModel) {
    Button(
        onClick = { viewModel.clearSelectedOption() },
        modifier = Modifier.wrapContentSize()
    ) {
        Text("Clear All Sets", fontSize = 20.sp)
    }
}

@Composable
fun ExternalRotator(navController: NavController, viewModel: ExerciseViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Text("External Rotator", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(8.dp))
        ImageSectionExternalRotator()
        InstructionsTextExternalRotator()
        Spacer(modifier = Modifier.height(8.dp)) // Control this value to adjust spacing
        Spacer(modifier = Modifier.height(8.dp))
        RadioButtonsSection(navController, viewModel)
        NextExerciseButtonExternalRotator(navController)
        BackToExerciseListButton(navController)
        ClearAllSetsButtonExternalRotator(viewModel)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewExternalRotator() {
    val navController = rememberNavController()
    PendulumSwing(navController)
}

