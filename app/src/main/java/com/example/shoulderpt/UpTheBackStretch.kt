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
fun ImageSectionUpTheBackStretch() {
    Image(
        painter = painterResource(id = R.drawable.upthebackstretch),
        contentDescription = "Up The Back Stretch",
        modifier = Modifier.size(250.dp)
    )
}

@Composable
fun InstructionsTextUpTheBackStretch() {
    val text = """
        1. Light Stretch - Put your hand in your back pocket
        2. Moderate Stretch - Hold your arm behind your back, palm out & with other hand pull the hand up
        3. Put towel over shoulder - pull down with good arm to draw up the injured shoulder 
        4. Hold each exercise for 15-30 seconds and repeat 2 to 4 times
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
fun RadioButtonsSectionUpTheBackStretch(navController: NavController, viewModel: ExerciseViewModel) {
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
fun NextExerciseButtonUpTheBackStretch(navController: NavController) {
    Button(onClick = { navController.navigate("OverheadStretch") }) {
        Text("To Next Exercise", fontSize = 20.sp)
    }
}

@Composable
fun BackToExerciseListButtonUpTheBackStretch(navController: NavController) {
    Button(onClick = { navController.navigate("HomePage") }) {
        Text("Back to Exercise List", fontSize = 20.sp)
    }
}

@Composable
fun ClearAllSetsButtonUpTheBackStretch(viewModel: ExerciseViewModel) {
    Button(
        onClick = { viewModel.clearSelectedOption() },
        modifier = Modifier.wrapContentSize()
    ) {
        Text("Clear All Sets", fontSize = 20.sp)
    }
}

@Composable
fun UpTheBackStretch(navController: NavController, viewModel: ExerciseViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Text("Up The Back Stretch", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(8.dp))
        ImageSectionUpTheBackStretch()
        InstructionsTextUpTheBackStretch()
        Spacer(modifier = Modifier.height(8.dp)) // Control this value to adjust spacing
        Spacer(modifier = Modifier.height(8.dp))
        RadioButtonsSection(navController, viewModel)
        NextExerciseButtonUpTheBackStretch(navController)
        BackToExerciseListButtonUpTheBackStretch(navController)
        ClearAllSetsButtonUpTheBackStretch(viewModel)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewUtTheBackStretch() {
    val navController = rememberNavController()
    PendulumSwing(navController)
}

