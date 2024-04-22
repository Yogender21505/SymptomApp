package com.aanchal.symptomapp.screens


import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.aanchal.symptomapp.Doctor
import com.aanchal.symptomapp.MainViewModel
import com.aanchal.symptomapp.R

@Composable
fun DoctorListScreen(
    navController: NavHostController,
    applicationContext: Context,
    viewModelmain: MainViewModel,
    doctors: List<Doctor>
) {
    Box(modifier = Modifier.fillMaxSize()) {
        val sortedDoctors = doctors
            .filter { it.specialist == "Psychiatrist" } // Change "Psychiatrist" to input string
            .sortedByDescending { it.userRating }
        Text(text = "Psychiatrist")
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            DoctorNav(navController)
            Text(text = "Psychiatrist")
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(sortedDoctors) { doctor ->
                    profileDetailsList(doctor,navController)
                }
            }
        }
    }
}
@Composable
fun profileDetailsList(doctor: Doctor, navController: NavHostController) {

    Row(modifier = Modifier
        .padding(20.dp)
        .fillMaxWidth()) {
        DocimageList()
        Spacer(modifier = Modifier.padding(6.dp))
        Column() {
            Text(text = "Dr. ${doctor.name}", fontSize = 25.sp, color = Color.Black, modifier = Modifier)
            Text(text = "${doctor.specialist}", fontSize = 15.sp, color = Color.Black, modifier = Modifier)
            Spacer(modifier = Modifier.padding(6.dp))
            Row() {
                Box(modifier = Modifier.background(Color(0xFF00B9E4))){
                    Icon(imageVector = Icons.Filled.Star, contentDescription = "Rating_Star", tint = Color.White)
                }
                Spacer(modifier = Modifier.padding(6.dp))
                Text(text = "${doctor.userRating}",color = Color.Black)
            }
        }
            IconButton(onClick = { navController.navigate("doctor_details/${doctor.doctorId}")}){
                Icon(modifier = Modifier.align(Alignment.CenterVertically),imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = "movetodoctor")
            }
    }
}
@Composable
fun DocimageList() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = Modifier
            .size(width = 100.dp, height = 150.dp)
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(id = R.drawable.doc_image),
            contentDescription = "docImage",
            contentScale = ContentScale.Crop
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DoctorNav(navController: NavHostController) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    CenterAlignedTopAppBar(
        title = {
        },
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack()}) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "menu"
                )
            }
        },
        actions = {
        },
        scrollBehavior = scrollBehavior,
    )
}

