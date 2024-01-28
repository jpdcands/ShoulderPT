package com.example.shoulderpt

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
class ExerciseViewModel : ViewModel() {
//    LiveData to hold the selected option
    var selectedOption = mutableStateOf("0")

//    Function to update the selected option
    fun updateSelectedOption(newOption: String) {
        selectedOption.value = newOption
    }
}