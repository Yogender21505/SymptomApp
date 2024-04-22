package com.aanchal.symptomapp.geminidatamanager

sealed class ChatUIEvent {
    data class UpdatePrompt(val newPrompt: String): ChatUIEvent()
    data class SendPrompt(val prompt: String): ChatUIEvent()
}