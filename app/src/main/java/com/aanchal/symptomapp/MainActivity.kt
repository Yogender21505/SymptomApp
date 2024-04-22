package com.aanchal.symptomapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.aanchal.symptomapp.ui.theme.SymptomAppTheme
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.aanchal.symptomapp.presentation.onboarding.OnBoardingScreen
import com.aanchal.symptomapp.screens.AppointmentScreen
import com.aanchal.symptomapp.screens.DoctorListScreen
import com.aanchal.symptomapp.screens.SearchScreen

class MainActivity  : ComponentActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       installSplashScreen()
        setContent {
            SymptomAppTheme {
                val navController = rememberNavController()
                val viewModelmain:MainViewModel = viewModel()
                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)) {

                    NavHost(navController, startDestination=viewModelmain.startdestination.value){
                            composable("onBoarding"){
                                OnBoardingScreen(navController,viewModelmain)
                            }
                            composable("searchScreen"){
                                SearchScreen(navController,applicationContext,viewModelmain)
                            }
                            composable("doctorList"){
                                DoctorListScreen(navController,applicationContext,viewModelmain)
                            }
                            composable("appointmentScreen"){
                                AppointmentScreen(navController,applicationContext,viewModelmain)
                            }
                    }
                }
            }
        }
    }
}
