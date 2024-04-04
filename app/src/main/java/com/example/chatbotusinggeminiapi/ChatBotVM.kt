package com.example.chatbotusinggeminiapi

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.launch

class ChatBotVM : ViewModel() {
    val list by lazy {
        mutableStateListOf<ChatData>()    }

    private val genAI by lazy {
        GenerativeModel(
            modelName = "gemini-pro", apiKey = API_KEY
        )
    }

    fun sendMessage(message: String) = viewModelScope.launch {
        val chat = genAI.startChat()
        // user message
        list.add(ChatData(message, ChatRoleEnum.USER.role))
//        Log.d("ListSizeBefore", "sendMessage (before update): list size - ${list.size}")

        chat.sendMessage(content(ChatRoleEnum.USER.role) { text(message) }).text?.let {
            // model response
            list.add(ChatData(it, ChatRoleEnum.MODEL.role))
//            Log.d("ListSizeAfter", "sendMessage (after update): list size - ${list.size}")
        }
    }
}