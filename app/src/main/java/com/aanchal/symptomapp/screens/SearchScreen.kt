package com.aanchal.symptomapp.screens

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.aanchal.symptomapp.MainViewModel
import com.aanchal.symptomapp.geminidatamanager.ChatState
import com.aanchal.symptomapp.geminidatamanager.ChatUIEvent
import com.aanchal.symptomapp.geminidatamanager.ChatViewModel
import com.aanchal.symptomapp.userdata.UserViewModel
import kotlinx.coroutines.delay

@Composable
fun SearchScreen(
    navController: NavHostController,
    applicationContext: Context,
    viewModelmain: MainViewModel,
    chatState: ChatState,
    chatViewModel: ChatViewModel,
    userViewModel: UserViewModel
) {

    Box(modifier = Modifier.fillMaxSize()) {

        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {
//            ProfileWithMenu()
            Column(modifier = Modifier.weight(1f)) { // Allow this column to take up remaining space
                Text(text = "Hello,",modifier = Modifier.padding(6.dp),fontSize = 15.sp)
                Text(text = "${userViewModel.userName.value}",fontSize = 25.sp,modifier = Modifier.padding(10.dp),style = LocalTextStyle.current, fontWeight = FontWeight.ExtraBold)

                SearchBarCard(chatViewModel,chatState){

                        navController.navigate("doctorList")
                }
                Spacer(modifier = Modifier.padding(50.dp))
            }
            println(chatState.chatList.toString())

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarCard(chatViewModel: ChatViewModel, chatState: ChatState, onClick: () -> Unit) {


    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF00B9E4),
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 80.dp, start = 20.dp, end = 20.dp)
    ) {
        Text(
            text = "Elaborate Symptoms To Get Specialist of Disease",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(20.dp),
            color = Color.White
        )
        Box {
            // Search bar field with trailing icon button
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                value = chatState.prompt,
                colors = TextFieldDefaults.textFieldColors(
                    cursorColor = Color.Black,
                    disabledLabelColor = Color.Transparent,
                    containerColor = Color(0xff009ABE),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                onValueChange = { chatViewModel.onEvent(ChatUIEvent.UpdatePrompt(it)) },
                shape = RoundedCornerShape(50.dp),
                placeholder = {
                    Text(text = "Elaborate Symptoms here!", fontSize = 10.sp)
                },
                singleLine = false,
                trailingIcon = {

                    if (chatViewModel.isLoading.value) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .padding(16.dp)
                                .size(24.dp),
                            color = Color.White
                        )
                    } else {
                        IconButton(onClick = {
                            chatViewModel.isLoading.value = true
                            chatViewModel.onEvent(ChatUIEvent.SendPrompt('"'+chatState.prompt+'"'+", for these symptoms give me specialist from this list Cardiologist, Dermatologist, Endocrinologist, Gastroenterologist, Hematologist, Obstetrician, Gynecologist, Oncologist, Ophthalmologist, Orthopedic Surgeon, Otolaryngologist, Pediatrician, Psychiatrist, Pulmonologist, Rheumatologist, Urologist, Allergist, Immunologist, Infectious Disease Specialist, Nephrologist, Neurologist, Physical Therapist whom I should contact. Give me comma seperated specilaist only, nothing else"))
                            onClick()
                        }) {
                            // Icon you want to display

                            Icon(
                                imageVector = Icons.Filled.Send,
                                contentDescription = "send_button",
                                tint = Color.White
                            )
                        }
                    }
                }
            )
        }
    }
}
//@SuppressLint("SuspiciousIndentation")
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun ProfileWithMenu() {
//    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
//
//    CenterAlignedTopAppBar(
//        title = {
//        },
//        navigationIcon = {
//            IconButton(onClick = { /* do something */ }) {
//                Icon(
//                    imageVector = Icons.Filled.Menu,
//                    contentDescription = "menu"
//                )
//            }
//        },
//        actions = {
//            IconButton(onClick = { /* do something */ }) {
//                Icon(
//                    imageVector = Icons.Filled.Person,
//                    contentDescription = "profile"
//                )
//            }
//        },
//        scrollBehavior = scrollBehavior,
//    )
//}
