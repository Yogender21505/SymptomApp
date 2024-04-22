package com.aanchal.symptomapp.screens

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.aanchal.symptomapp.MainViewModel

@Composable
fun SearchScreen(
    navController: NavHostController,
    applicationContext: Context,
    viewModelmain: MainViewModel
) {
    Box(modifier = Modifier.fillMaxSize()) {

        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            ProfileWithMenu()
            Column(modifier = Modifier.fillMaxSize()) {
                Text(text = "Hello, Good Afternoon",modifier = Modifier.padding(20.dp))
                Text(text = "Aanchal Gupta",fontSize = 20.sp,modifier = Modifier.padding(20.dp),style = LocalTextStyle.current)
                SearchBarCard()
                Spacer(modifier = Modifier.padding(50.dp))
                SubmitButton(){
                    viewModelmain.changedestination("doctorList")
                }
            }
        }
    }

}

@Composable
fun SubmitButton(onClick: () -> Unit) {
    Button(
        onClick = { onClick() },
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp),
        colors = ButtonDefaults.buttonColors(Color(0xFF04132D),Color.White),
        content = {
            Row {
                Text(text = "Submit", color = Color.White)
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowRight,
                    contentDescription = "rightArrow",
                    tint = Color.White
                )
            }
        }
    )
}


@Composable
fun SearchBarCard() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF00B9E4),
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(top = 80.dp, start = 20.dp, end = 20.dp)
    ) {
        Text(text = "Elaborate Symptoms To Get Specialist of Disease",fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(20.dp),
            color = Color.White
        )
        TextBox()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextBox() {
    var text by remember { mutableStateOf("") }

    val lightBlue = Color(0xffd8e6ff)
    val blue = Color(0xff76a9ff)
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, start = 20.dp, end = 20.dp, bottom = 20.dp)
        ,
        value = text,
        colors = TextFieldDefaults.textFieldColors(
            cursorColor = Color.Black,
            disabledLabelColor = Color.Transparent,
            containerColor = Color(0xff009ABE),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        onValueChange = { text = it },
        shape = RoundedCornerShape(50.dp),
        singleLine = false,
        trailingIcon = {
            if (text.isNotEmpty()) {
                IconButton(onClick = { text = "" }) {
                    Icon(
                        imageVector = Icons.Outlined.Close,
                        contentDescription = null
                    )
                }
            }
        }
    )
}
@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileWithMenu() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    CenterAlignedTopAppBar(
        title = {
        },
        navigationIcon = {
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "menu"
                )
            }
        },
        actions = {
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "profile"
                )
            }
        },
        scrollBehavior = scrollBehavior,
    )
}
