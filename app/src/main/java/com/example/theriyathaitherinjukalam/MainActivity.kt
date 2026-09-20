package com.example.theriyathaitherinjukalam
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp





class MainActivity : ComponentActivity() {
    override fun
            onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                ChatScreen()
            }
        }
            }
}
@Composable
fun ChatScreen() {
    var question = remember {
        mutableStateOf("")}
    val messages = remember {
        mutableStateListOf<String>()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "ெதரியாதைத ெதரிஞ்சு ெதரிஞ்சுக்கலாம்",
            style =
                MaterialTheme.typography.headlineSmall
        )
        Spacer(
            modifier = Modifier.height(16.dp))
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement =
                Arrangement.spacedBy(8.dp)         )
        {
            items(messages)
            { message ->
                Text(
                    text = message,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = question.value,
                onValueChange = { question.value = it },
                modifier = Modifier.weight(1f),
                placeholder = {
                    Text("உங்கள் ேகள்விைய எழுதுங்கள்")
                              },
                singleLine = true
            )
            Spacer(
                modifier = Modifier.width(8.dp))
            Button(
                onClick = {
                    if (question.value.isNotBlank()) {
                        messages.add("Q: ${question.value}")
                        messages.add("A: API இைணத்த பிறகு உண்ைமயான பதில் வரும்.")
                        question.value = ""
                    }
                }
            )
            {
                Text("அனுப்பு")
            }
        }
    }
}