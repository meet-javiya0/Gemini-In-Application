package com.example.chatbotusinggeminiapi

sealed interface ChatBotUIState {
    data object Idle : ChatBotUIState
    data object Loading : ChatBotUIState
    data class Success(val chatData: String) : ChatBotUIState
    data class Error(val chatError: String) : ChatBotUIState
}