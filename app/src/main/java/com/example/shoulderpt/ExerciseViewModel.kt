package com.example.shoulderpt

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

class ExerciseViewModel(private val state: SavedStateHandle) : ViewModel() {
    companion object {
        private const val OPTIONS_KEY = "options_key"
        private const val SELECTED_OPTION_KEY = "selected_option_key"
        //Add a key (above) for saving the selected option
        private val defaultOptions = listOf("Set 1", "Set 2", "Set 3", "Set 4")
    }

    var options: List<String>
        
        get() = state.get<List<String>>(OPTIONS_KEY) ?: defaultOptions
        set(value) {
            state[OPTIONS_KEY] = value
        }

    // Use MutableState for selectedOption, but also save and restore it from SavedStateHandle
    var selectedOption = mutableStateOf<String?>(state.get(SELECTED_OPTION_KEY))
        private set // Make the setter private to restrict modifications from outside the ViewModel

    fun updateSelectedOption(option: String) {
        selectedOption.value = option
        state[SELECTED_OPTION_KEY] = option  // Save the selected option in SavedStateHandle
    }

    fun clearSelectedOption() {
        selectedOption.value = null // Resetting to null or to a default value indicating no selection
    }
}


