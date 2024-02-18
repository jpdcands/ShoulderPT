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
fun PosteriorStretching(navController: NavController, viewModel: ExerciseViewModel = viewModel()) {

    var selectedOption = viewModel.selectedOption.value
    val options = viewModel.options

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(20.dp)) // Increased height
        Text("Posterior Stretching", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(2.dp))
        Image(
            painter = painterResource(id = R.drawable.posteriorstretching), // Replace with your image resource
            contentDescription = "Posterior Stretching",
            modifier = Modifier.size(250.dp)
        )
        val text = """
            1. Hold the elbow of the affected arm with your other hand.
            2. Use your hand to gently pull your arm up and across your body.
            3. Hold for 15 - 30 seconds.
            4. Repeat 2 to 4 times.
            """.trimIndent()
        val modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
        val style = MaterialTheme.typography.bodyLarge
        Text(text = text, modifier = modifier, style = style)
        Spacer(modifier = Modifier.height(16.dp))
        // Horizontal arrangement of radio buttons
        Row(
            horizontalArrangement = Arrangement.Center, // Center the radio buttons in the Row
            modifier = Modifier.fillMaxWidth() // Fill the width of the parent
        ) {
            options.forEach { option ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = option, textAlign = TextAlign.Center)
                    RadioButton(
                        selected = selectedOption == option,
                        onClick = { viewModel.updateSelectedOption(option) }
                    )
                }
                Spacer(modifier = Modifier.width(20.dp)) // Space between each radio button group
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        // First button
        Button(onClick = {  navController.navigate("ScapularRetraction") }) {
            Text("To Next Exercise", fontSize = 20.sp)
        }

        Spacer(modifier = Modifier.height(30.dp))

        // Second button
        Button(onClick = { navController.navigate("HomePage") }) {
            Text("Back to Exercise List", fontSize = 20.sp)
        }
        Button(onClick = {
            viewModel.clearSelectedOption() // Clears the selection
        },
            modifier = Modifier.wrapContentSize()
        ) {
            Text("Clear All Sets", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewPosteriorStretching() {

    val navController = rememberNavController()

    PosteriorStretching(navController)
}
