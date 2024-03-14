package com.example.shoulderpt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shoulderpt.ui.theme.ShoulderPTTheme


class Welcome : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: ExerciseViewModel by viewModels()

        setContent {
            ShoulderPTTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp(viewModel = viewModel)
                }
            }
        }
    }
}

sealed class Screen(val route: String) {
    object Welcome : Screen("Welcome")
    object HomePage : Screen("HomePage")
    object PendulumSwing : Screen("PendulumSwing")
    object PosteriorStretching : Screen("PosteriorStretching")
    object UpTheBackStretch : Screen("UpTheBackStretch")
    object OverheadStretch : Screen("OverheadStretch")
    object ShoulderFlexion : Screen("ShoulderFlexion")
    object ShoulderRotation : Screen("ShoulderRotation")
    object WallClimbingSide : Screen("WallClimbingSide")
    object WallClimbingFront : Screen("WallClimbingFront")
    object ShoulderBladeSqueeze : Screen("ShoulderBladeSqueeze")
    object ScapularArmReach : Screen("ScapularArmReach")
    object ArmRaiseSide : Screen("ArmRaiseSide")
    object ShoulderFlexorAndExtensor : Screen("ShoulderFlexorAndExtensor")
    object WallPushUp : Screen("ScapularWallPushUp")
    object ScapularRetraction : Screen("ScapularRetraction")
    object InternalRotator : Screen("InternalRotator")
    object ExternalRotator : Screen("ExternalRotator")

}

@Composable
fun MyApp(viewModel: ExerciseViewModel) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Welcome.route) {

        composable(Screen.Welcome.route) {
            Welcome(navController) }
        composable(Screen.HomePage.route) {
            HomePage(navController, viewModel) }
        composable(Screen.PendulumSwing.route) {
            PendulumSwing(navController, viewModel) }
        composable(Screen.UpTheBackStretch.route) {
            UpTheBackStretch(navController, viewModel) }
        composable(Screen.ArmRaiseSide.route) {
            ArmRaiseSide(navController, viewModel) }
        composable(Screen.ShoulderFlexion.route) {
            ShoulderFlexion(navController, viewModel) }
        composable(Screen.OverheadStretch.route) {
            OverheadStretch(navController, viewModel) }
        composable(Screen.PosteriorStretching.route) {
            PosteriorStretching(navController, viewModel) }
        composable(Screen.ShoulderRotation.route) {
            ShoulderRotation(navController, viewModel) }
        composable(Screen.WallClimbingSide.route) {
            WallClimbingSide(navController, viewModel) }
        composable(Screen.WallClimbingFront.route) {
            WallClimbingFront(navController, viewModel) }
        composable(Screen.ShoulderBladeSqueeze.route) {
            ShoulderBladeSqueeze(navController, viewModel) }
        composable(Screen.ScapularArmReach.route) {
            ScapularArmReach(navController, viewModel) }
        composable(Screen.ShoulderFlexorAndExtensor.route) {
            ShoulderFlexorAndExtensor(navController, viewModel) }
        composable(Screen.WallPushUp.route) {
            ScapularWallPushUp(navController, viewModel) }
        composable(Screen.ScapularRetraction.route) {
            ScapularRetraction(navController, viewModel) }
        composable(Screen.InternalRotator.route) {
            InternalRotator(navController, viewModel) }
        composable(Screen.ExternalRotator.route) {
            ExternalRotator(navController, viewModel) }
    }
}

@Composable
fun Welcome(navController: NavController) {
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
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
                            .padding(top = 1.dp),
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(
                            fontSize = 44.sp
                        )
                    )
                    Text(
                        text = "Cuff Exercises",
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 1.dp),
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(
                            fontSize = 44.sp, // Font size for the second part
                            textAlign = TextAlign.Center // Centers the text within its composable
                        )
                    )
                    Spacer(modifier = Modifier.height(90.dp))
                    // LazyColumn for the list of exercises
                    //   NamesLazyColumn(navController)

                    Image(
                        painter = painterResource(id = R.drawable.myshoulderpain), // Replace with your image resource
                        modifier = Modifier
                            .size(300.dp, 300.dp)
                            .clip(RoundedCornerShape(26.dp)),
                        contentScale = ContentScale.Crop,
                        contentDescription = "Shoulder Picture",

                        )
                    Spacer(modifier = Modifier.height(40.dp)) // Adjust the height as needed

                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp)
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Button(onClick = { navController.navigate("HomePage") }) {
                                Text("Begin Exercises", fontSize = 30.sp)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyAppPreview() {
    // Create a dummy NavController for preview purposes
    val navController = rememberNavController()

    ShoulderPTTheme {
        Welcome(navController)
    }
}