package com.example.shoulderpt

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview
import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
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

import com.example.shoulderpt.HomePage
import com.example.shoulderpt.Pendulum
import com.example.shoulderpt.PosteriorStretching


class Welcome  : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

sealed class Screen(val route: String) {
    object Welcome : Screen("Welcome")
    object HomePage : Screen("HomePage")
    object Pendulum : Screen("Pendulum")
    object PosteriorStretching : Screen("PosteriorStretching")
    object UpTheBackStretch : Screen("UpTheBackStretch")
    object OverheadStretch : Screen("OverheadStretch")
    object ShoulderFlexor : Screen("ShoulderFlexor")
    object ShoulderRotation : Screen("ShoulderRotation")
    object WallClimberSide : Screen("WallClimberSide")
    object WallClimberFront : Screen("WallClimberFront")
    object ShoulderBladeSqueeze : Screen("ShoulderBladeSqueeze")
    object ArmReachFront : Screen("ArmReachFront")
    object ArmReachSide : Screen("ArmReachSide")
    object ShoulderFlexorAndExtensor : Screen("ShoulderFlexorAndExtensor")
    object ArmRaiseSide : Screen("ArmRaiseSide")
    object WallPushUp : Screen("WallPushUp")
    object ScapularRetraction : Screen("ScapularRetraction")
    object InternalRotator : Screen("InternalRotator")
    object ExternalRotator : Screen("ExternalRotator")

    }

@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Welcome.route) {
        composable(Screen.Welcome.route) { Welcome(navController) }
        composable(Screen.HomePage.route) { HomePage(navController) }
        composable(Screen.Pendulum.route) { Pendulum(navController) }
        composable(Screen.UpTheBackStretch.route) { UpTheBackStretch(navController) }
        composable(Screen.ArmRaiseSide.route) { ArmRaiseSide(navController) }
        composable(Screen.ShoulderFlexor.route) { ShoulderFlexor(navController) }
        composable(Screen.OverheadStretch.route) { OverheadStretch(navController) }
        composable(Screen.PosteriorStretching.route) { PosteriorStretching(navController) }
        composable(Screen.ShoulderRotation.route) { ShoulderRotation(navController) }
        composable(Screen.WallClimberSide.route) { WallClimberSide(navController) }
        composable(Screen.WallClimberFront.route) { WallClimberFront(navController) }
        composable(Screen.ShoulderBladeSqueeze.route) { ShoulderBladeSqueeze(navController) }
        composable(Screen.ArmReachFront.route) { ArmReachFront(navController) }
        composable(Screen.ArmReachSide.route) { ArmReachSide(navController) }
        composable(Screen.ShoulderFlexorAndExtensor.route) { ShoulderFlexorAndExtensor(navController) }
        composable(Screen.WallPushUp.route) { WallPushUp(navController) }
        composable(Screen.ScapularRetraction.route) { ScapularRetraction(navController) }
        composable(Screen.InternalRotator.route) { InternalRotator(navController) }
        composable(Screen.ExternalRotator.route) { ExternalRotator(navController) }
    }
}

@Composable
 fun Welcome(navController: NavController) {
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
                Spacer(modifier = Modifier.height(60.dp))
                // LazyColumn for the list of exercises
             //   NamesLazyColumn(navController)

                Image(
                    painter = painterResource(id = R.drawable.shoulderpain), // Replace with your image resource
                    contentDescription = "Over the Head Stretch",
                    modifier = Modifier.size(250.dp)
                )

       Box(
           contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
              Column(horizontalAlignment = Alignment.CenterHorizontally) {
                  Button(onClick = { navController.navigate("HomePage") }) {
                       Text("Begin Exercises", fontSize = 20.sp)
                        }
                    }
                }
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    // Create a dummy NavController for preview purposes
    val navController = rememberNavController()

    ShoulderPTTheme {
        Welcome(navController)
    }
}