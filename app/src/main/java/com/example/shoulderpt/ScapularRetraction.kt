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
fun ImageSectionScapularRetraction() {
    Image(
        painter = painterResource(id = R.drawable.scapularretractionpulley),
        contentDescription = "Scapular Retraction",
        modifier = Modifier.size(250.dp)
    )
}

@Composable
fun InstructionsTextScapularRetraction() {
    val text = """
        1. With a band around a wall anchor at waist height hold each end
        2. With elbows at sides and at 90 degrees pull the band back
        3. As ROM increases gradually lift arms out to the side
        4. Repeat 8-12 times doing 3 sets per day
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
fun RadioButtonsSectionScapularRetraction(navController: NavController, viewModel: ExerciseViewModel) {
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
fun NextExerciseButtonScapularRetraction(navController: NavController) {
    Button(onClick = { navController.navigate("InternalRotator") }) {
        Text("To Next Exercise", fontSize = 20.sp)
    }
}

@Composable
fun BackToExerciseListScapularRetraction(navController: NavController) {
    Button(onClick = { navController.navigate("HomePage") }) {
        Text("Back to Exercise List", fontSize = 20.sp)
    }
}

@Composable
fun ClearAllSetsButtonScapularRetraction(viewModel: ExerciseViewModel) {
    Button(
        onClick = { viewModel.clearSelectedOption() },
        modifier = Modifier.wrapContentSize()
    ) {
        Text("Clear All Sets", fontSize = 20.sp)
    }
}

@Composable
fun ScapularRetraction(navController: NavController, viewModel: ExerciseViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Text("Scapular Retraction", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(8.dp))
        ImageSectionScapularRetraction()
        InstructionsTextScapularRetraction()
        Spacer(modifier = Modifier.height(8.dp)) // Control this value to adjust spacing
        Spacer(modifier = Modifier.height(8.dp))
        RadioButtonsSection(navController, viewModel)
        NextExerciseButtonScapularRetraction(navController)
        BackToExerciseListButton(navController)
        ClearAllSetsButtonScapularRetraction(viewModel)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewScapularRetraction() {
    val navController = rememberNavController()
    PendulumSwing(navController)
}

