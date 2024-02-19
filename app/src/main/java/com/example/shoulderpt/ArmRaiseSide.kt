package com.example.shoulderpt

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
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
fun ArmRaiseSide(navController: NavController, viewModel: ExerciseViewModel = viewModel()) {
    // Obtain an instance of ExerciseViewModel using the viewModel() function
    // This collects the state from the ViewModel
    val selectedOption = viewModel.selectedOption.value
    val options = viewModel.options

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            "Arm Raise Side",
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.height(2.dp))
        Image(
            painter = painterResource(id = R.drawable.armraiseside),
            contentDescription = "Scapular Exercise: Arm Reach",
            modifier = Modifier.size(250.dp)
        )
        Text(
            text = """
                1. This exercise does not use the arm muscles - use your legs and hips to create movement.
                2. Swing arm back and forth like a pendulum then use your hips to make circles
                3. Do this exercise for 5 minutes 4 times a day.
                4. As pain decreases, try bending over further.
            """.trimIndent(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Using Row and Column for radio buttons and their labels
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            options.forEach { option ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(8.dp) // Provide padding around each option for better spacing
                ) {
                    RadioButton(
                        selected = selectedOption == option,
                        onClick = { viewModel.updateSelectedOption(option) }
                    )
                    Text(text = option) // Label below the RadioButton for clarity
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Buttons in a Row for horizontal alignment
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
          //  horizontalArrangement = Arrangement.SpaceEvenly, // Space buttons evenly in the available space
           // modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = { navController.navigate("ShoulderFlexorAndExtensor") },
                modifier = Modifier.wrapContentSize() // Use wrapContentSize for buttons
            ) {
                Text("To Next Exercise", fontSize = 20.sp)
            }

            Spacer(modifier = Modifier.height(8.dp)) // Space between buttons

            Button(
                onClick = { navController.navigate("HomePage") },
                modifier = Modifier.wrapContentSize() // Use wrapContentSize for buttons
            ) {
                Text("Back to Exercise List", fontSize = 20.sp)
            }
            Spacer(modifier = Modifier.height(8.dp))
            // Space between buttons
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
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewArmRaiseSide() {
    val navController = rememberNavController()
    ArmRaiseSide(navController)
}

