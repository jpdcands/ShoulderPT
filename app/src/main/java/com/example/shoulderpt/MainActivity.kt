package com.example.shoulderpt

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.unit.sp
import com.example.shoulderpt.ui.theme.ShoulderPTTheme

import com.example.shoulderpt.SecondPage


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "landingPage") {
        composable("landingPage") { LandingPage(navController) }
        composable("secondPage") { SecondPage(navController) }
    }
}

@Composable
 fun LandingPage(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            contentAlignment = Alignment.Center, // Aligns the content to the center
            modifier = Modifier.fillMaxSize()    // Fills the entire screen
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Shoulder/Rotator",
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 100.dp),
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        fontSize = 44.sp
                    )
                )
                Text(
                    text = "Cuff Exercises",
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(vertical = 8.dp),
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        fontSize = 44.sp, // Font size for the second part
                        textAlign = TextAlign.Center // Centers the text within its composable
                    )
                )
                Spacer(modifier = Modifier.height(100.dp))
                // LazyColumn for the list of exercises
             //   NamesLazyColumn(navController)

       Box(
           contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
              Column(horizontalAlignment = Alignment.CenterHorizontally) {
                  Button(onClick = { navController.navigate("secondPage") }) {
                       Text("Begin Exercises", fontSize = 20.sp)
                        }
                    }
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    // Create a dummy NavController for preview purposes
    val navController = rememberNavController()

    ShoulderPTTheme {
        LandingPage(navController)
    }
}