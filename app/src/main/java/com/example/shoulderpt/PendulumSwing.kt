package com.example.shoulderpt

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun ImageSection() {
    Image(
        painter = painterResource(id = R.drawable.pendulumswing),
        contentDescription = "Pendulum Swing",
        modifier = Modifier.size(250.dp)
    )
}

@Composable
fun InstructionsText() {
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
            .padding(10.dp)
    )
}

@Composable
fun RadioButtonsSection(navController: NavController, viewModel: ExerciseViewModel) {
    val selectedOption = viewModel.selectedOption.value
    val options = viewModel.options

    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        options.forEach { option ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
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
fun NextExerciseButton(navController: NavController) {
    Button(onClick = { navController.navigate("PosteriorStretching") }) {
        Text("To Next Exercise", fontSize = 20.sp)
    }
}

@Composable
fun BackToExerciseListButton(navController: NavController) {
    Button(onClick = { navController.navigate("HomePage") }) {
        Text("Back to Exercise List", fontSize = 20.sp)
    }
}

@Composable
fun ClearAllSetsButton(viewModel: ExerciseViewModel) {
    Button(
        onClick = { viewModel.clearSelectedOption() },
        modifier = Modifier.wrapContentSize()
    ) {
        Text("Clear All Sets", fontSize = 20.sp)
    }
}

@Composable
fun PendulumSwing(navController: NavController, viewModel: ExerciseViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Text("Pendulum Swing", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(8.dp))
        ImageSection()
        InstructionsText()
        Spacer(modifier = Modifier.height(8.dp))
        RadioButtonsSection(navController, viewModel)
    //   Spacer(modifier = Modifier.height(16.dp))
        NextExerciseButton(navController)
      //  Spacer(modifier = Modifier.height(20.dp))
        BackToExerciseListButton(navController)
        ClearAllSetsButton(viewModel)
     //   Spacer(modifier = Modifier.height(8.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewPendulum() {

    val navController = rememberNavController()

    PendulumSwing(navController)
}





