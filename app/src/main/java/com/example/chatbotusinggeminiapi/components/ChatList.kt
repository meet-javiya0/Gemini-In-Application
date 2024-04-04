package com.example.chatbotusinggeminiapi.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.chatbotusinggeminiapi.ChatData
import com.example.chatbotusinggeminiapi.ChatRoleEnum

@Composable
fun ChatList(list: MutableList<ChatData>) {
    LazyColumn(Modifier.fillMaxSize()) {
        items(list) {
            if (it.role == ChatRoleEnum.USER.role) {
                Text(
                    text = it.message,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black)
                        .padding(12.dp),
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontStyle = FontStyle.Normal
                )
            } else {
                Text(
                    text = it.message,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray)
                        .padding(12.dp),
                    color = Color.Black,
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Normal
                )
            }
        }
    }
}