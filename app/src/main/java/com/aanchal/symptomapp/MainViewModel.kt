package com.aanchal.symptomapp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class MainViewModel(): ViewModel() {
    var startdestination = mutableStateOf("onBoarding")
    fun changedestination(desti: String){
        viewModelScope.launch {
            startdestination.value= desti

        }
    }
}