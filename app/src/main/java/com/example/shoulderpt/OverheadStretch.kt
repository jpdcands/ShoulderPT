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
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
@Composable
fun ImageSectionOverheadStretch() {
    Image(
        painter = painterResource(id = R.drawable.overtheheadstretch),
        contentDescription = "Over The Head Stretch",
        modifier = Modifier.size(250.dp)
    )
}

@Composable
fun InstructionsTextOverheadStretch() {
    val text = """
        1. With your arms straight, bend over and hold onto a solid surface
        2. With knees bent, bend over with arms straight
        3. Lower your upper body and let your shoulder stretch
        4. Hold for 15-30 seconds and repeat 2-4 times
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
fun RadioButtonsSectionOverheadStretch(navController: NavController, viewModel: ExerciseViewModel) {
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
fun NextExerciseButtonOverheadStretch(navController: NavController) {
    Button(onClick = { navController.navigate("ShoulderFlexion") }) {
        Text("To Next Exercise", fontSize = 20.sp)
    }
}

@Composable
fun BackToExerciseListButtonOverheadStretch(navController: NavController) {
    Button(onClick = { navController.navigate("HomePage") }) {
        Text("Back to Exercise List", fontSize = 20.sp)
    }
}

@Composable
fun ClearAllSetsButtonOverheadStretch(viewModel: ExerciseViewModel) {
    Button(
        onClick = { viewModel.clearSelectedOption() },
        modifier = Modifier.wrapContentSize()
    ) {
        Text("Clear All Sets", fontSize = 20.sp)
    }
}

@Composable
fun OverheadStretch(navController: NavController, viewModel: ExerciseViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Text("Over The Head Stretch", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(8.dp))
        ImageSectionOverheadStretch()
        InstructionsTextOverheadStretch()
        Spacer(modifier = Modifier.height(8.dp)) // Control this value to adjust spacing
        Spacer(modifier = Modifier.height(8.dp))
        RadioButtonsSection(navController, viewModel)
        NextExerciseButtonOverheadStretch(navController)
        BackToExerciseListButtonOverheadStretch(navController)
        ClearAllSetsButtonOverheadStretch(viewModel)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewOverheadStretch() {
    val navController = rememberNavController()
    PendulumSwing(navController)
}

