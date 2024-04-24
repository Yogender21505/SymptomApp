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
//    private val _doctors = mutableStateOf<List<Doctor>>(emptyList())
//    val doctors: State<List<Doctor>> = _doctors
    private val _filteredDoctors = mutableStateOf<List<Doctor>>(emptyList())
    val filteredDoctors: State<List<Doctor>> = _filteredDoctors
    val medicalSpecialties = listOf(
        "Cardiologist",
        "Dermatologist",
        "Endocrinologist",
        "Gastroenterologist",
        "Hematologist",
        "Obstetrician",
        "Gynecologist",
        "Oncologist",
        "Ophthalmologist",
        "Orthopedic Surgeon",
        "Otolaryngologist",
        "Pediatrician",
        "Psychiatrist",
        "Pulmonologist",
        "Rheumatologist",
        "Urologist",
        "Allergist",
        "Immunologist",
        "Infectious Disease Specialist",
        "Nephrologist",
        "Neurologist",
        "Physical Therapist"
    )

    private val _isloading = mutableStateOf<Boolean>(false)
    val isloading: State<Boolean> = _isloading
    // Function to update the list of doctors
    fun updateDoctorList(newDoctors: List<Doctor>) {
        _filteredDoctors.value = newDoctors
    }
    fun updateisloadin(loading: Boolean){
        _isloading.value=loading
    }
}