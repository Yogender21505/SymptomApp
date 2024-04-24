package com.aanchal.symptomapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.aanchal.symptomapp.ui.theme.SymptomAppTheme
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.aanchal.symptomapp.appointmentdata.AppointmentDataViewModel
import com.aanchal.symptomapp.geminidatamanager.ChatViewModel
import com.aanchal.symptomapp.presentation.onboarding.OnBoardingScreen
import com.aanchal.symptomapp.screens.AppointmentScreen
import com.aanchal.symptomapp.screens.DoctorListScreen
import com.aanchal.symptomapp.screens.LoginScreen
import com.aanchal.symptomapp.screens.SearchScreen
import com.aanchal.symptomapp.screens.SuccessfullScreen
import com.aanchal.symptomapp.userdata.UserViewModel

class MainActivity  : ComponentActivity() {
    private lateinit var connectivityObserver: ConnectivityObserver
   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       connectivityObserver = NetworkConnectivityObserver(applicationContext)
       val doctors = DataManager.loadDoctorsFromJson(this)
       installSplashScreen()
        setContent {
            SymptomAppTheme {
                val status by connectivityObserver.observe().collectAsState(
                    initial = ConnectivityObserver.Status.Unavailable
                )
                val navController = rememberNavController()
                val viewModelmain:MainViewModel = viewModel()
                val chatViewModel =viewModel<ChatViewModel>()
                val userViewModel =viewModel<UserViewModel>()
                val chatState = chatViewModel.chatState.collectAsState().value
                val appointmentDataViewModel =viewModel<AppointmentDataViewModel>()
                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)) {

                    NavHost(navController, startDestination="onBoarding"){
                        if(status==ConnectivityObserver.Status.Lost){
                            navController.navigate("retry")
                        }
                            composable("onBoarding"){
                                OnBoardingScreen(navController,viewModelmain)
                            }
                            composable("guestLogin"){
                                LoginScreen(userViewModel,navController)
                            }
                            composable("searchScreen"){
                                SearchScreen(navController,chatState,chatViewModel,userViewModel)
                            }
                            composable("doctorList"){
                                DoctorListScreen(navController,applicationContext,viewModelmain,doctors,chatState,chatViewModel)
                            }
                            composable("doctor_details/{doctorId}") {
                                    backStackEntry ->
                                val doctorId = backStackEntry.arguments?.getString("doctorId")?.toIntOrNull() ?: -1
                                val doctor = doctors.find { it.doctorId == doctorId } ?: Doctor(0, "", "", 0.0, "", 0, "", "", "", "", "")
                                AppointmentScreen(navController,applicationContext,viewModelmain,doctor,appointmentDataViewModel,userViewModel)
                            }
                            composable("successfullPage") {
                                SuccessfullScreen(navController,viewModelmain,appointmentDataViewModel)
                            }
                            composable("retry"){
                                chatViewModel.isLoading.value=false
                                RetryScreen(navController)
                            }

                    }
                }
            }
        }
    }
}
