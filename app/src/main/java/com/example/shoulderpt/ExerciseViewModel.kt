package com.example.shoulderpt

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ExerciseViewModel : ViewModel() {
//    LiveData to hold the selected option
    var selectedOption = mutableStateOf("")

//    Function to update the selected option
    fun updateSelectedOption(option: String) {
        selectedOption.value = option
    }
}