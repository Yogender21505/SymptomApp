package com.aanchal.symptomapp.screens

import android.content.Context
import android.os.Build
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.aanchal.symptomapp.MainViewModel
import com.aanchal.symptomapp.R

@Composable
fun AppointmentScreen(
    navController: NavHostController,
    applicationContext: Context,
    viewModelmain: MainViewModel
) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Background Image
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.8f),
            painter = painterResource(id = R.drawable.topsheet),
            contentDescription = "upperImage",
            alignment = Alignment.TopCenter
        )

        // Content Column
        Column(modifier = Modifier.fillMaxSize()) {
            CenterAlignedTopAppBarExample()
            profileDetails()
            LazyColumn(modifier = Modifier.weight(1f)) {
                item { AboutCard() }
                item { DatePickerWithDateSelectableDatesSample() }
            }
        }

        // Floating Button
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp) // Adjust bottom padding as needed
        ) {
            BookAppointButton() {}
        }
    }
}
@Composable
fun BookAppointButton(onClick: () -> Unit) {
    LargeFloatingActionButton(
        onClick = { onClick() },
        shape = RectangleShape,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp)
            .clip(
                RoundedCornerShape(20.dp)
            ),
        containerColor = Color(0xFF04132D),
        content = {
            Row{
                Text(text = "Book An Appointment",color = Color.White)
                Icon(imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = "rightArrow",tint = Color.White)
            }
        }
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerWithDateSelectableDatesSample() {
    val datePickerState = rememberDatePickerState()


    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 40.dp, end = 20.dp, start = 20.dp)
    ) {
        DatePicker(state = datePickerState)
        //Text("Selected date timestamp: ${datePickerState.selectedDateMillis ?: "no selection"}")
    }

}

@Composable
fun AboutCard() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF4FDFF),
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Text(text = "About", fontSize = 25.sp, color = Color.Black, modifier = Modifier.padding(6.dp))
        Text(text = "Dr. Jenny WilsonDr. Jenny WilsonDr. Jenny WilsonDr. Jenny WilsonDr. Jenny WilsonDr. Jenny WilsonDr. Jenny WilsonDr. Jenny WilsonDr. Jenny WilsonDr. Jenny Wilson" +
                "Dr. Jenny WilsonDr. Jenny WilsonDr. Jenny Wilson", fontSize = 15.sp, color = Color.Black, modifier = Modifier.padding(6.dp))
    }
}
@Composable
fun profileDetails(){
    Row(modifier = Modifier
        .padding(20.dp)
        .fillMaxWidth()) {
        DocImageCard()
        Spacer(modifier = Modifier.padding(6.dp))
        Column() {
            Text(text = "Dr. Jenny Wilson", fontSize = 25.sp, color = Color.White, modifier = Modifier)
            Text(text = "Cardiologist Specialist", fontSize = 15.sp, color = Color.White, modifier = Modifier)
            Spacer(modifier = Modifier.padding(6.dp))
            Row() {
                Box(modifier = Modifier.background(Color(0xFF00B9E4))){
                    Icon(imageVector = Icons.Filled.Star, contentDescription = "Rating_Star", tint = Color.White)
                }
                Spacer(modifier = Modifier.padding(6.dp))
                Text(text = "4.5 Star",color = Color.White)
            }
        }
    }
}
@Composable
fun DocImageCard() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = Modifier
            .size(width = 150.dp, height = 170.dp)
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
fun CenterAlignedTopAppBarExample() {

    CenterAlignedTopAppBar(
        modifier = Modifier.padding(top = 20.dp),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent,
        ),
        title = {
        },
        navigationIcon = {
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "backbutton",
                    tint = Color.White
                )
            }
        },
        actions = {
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = "Calling",
                    tint = Color.White
                )
            }
        }
    )
}