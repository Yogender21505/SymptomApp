package com.aanchal.symptomapp.geminidatamanager

data class ChatState(
    val chatList: MutableList<Chat> = mutableListOf(),
    val prompt: String = ""
)
