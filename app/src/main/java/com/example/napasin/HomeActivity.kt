package com.example.napasin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    Scaffold(
        bottomBar = { BottomNavigationBar() }
    ) {
        MainContent(Modifier.padding(it))
    }
}

@Composable
fun MainContent(modifier: Modifier = Modifier) {
    val isRunning = remember { mutableStateOf(false) }
    val timerValue = remember { mutableStateOf(0) }

            LaunchedEffect(isRunning.value) {
                if (isRunning.value) {
                    while (isRunning.value) {
                        delay(1000L)
                        timerValue.value += 1
                    }
                }
            }

// Calculate current level
    val currentLevel = (timerValue.value / 10).coerceAtMost(10)

// Determine status based on current level
    val status = when (currentLevel) {
        in 0..3 -> "Not good"
        in 4..7 -> "Normal"
        in 8..10 -> "Very good"
        else -> ""
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Level: $currentLevel",
            fontSize = 24.sp,
            color = Color(0xFF005691)
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "$status",
            fontSize = 20.sp,
            color = when (status) {
                "Not good" -> Color.Red
                "Normal" -> Color.Black
                "Very good" -> Color.Green
                else -> Color.Black
            }
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "${timerValue.value} seconds",
            fontSize = 20.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (isRunning.value) {
                    isRunning.value = false
                    timerValue.value = 0
                } else {
                    isRunning.value = true
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF009FFF)),
            modifier = Modifier.padding(bottom = 32.dp)
        ) {
            Text(text = if (isRunning.value) "Stop" else "Start")
        }
    }
}

@Composable
fun BottomNavigationBar() {
    BottomAppBar(
        modifier = Modifier
            .fillMaxWidth(),
        containerColor = Color(0xFF0086F6),
        contentPadding = PaddingValues(0.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_home),
                    contentDescription = "Home",
                    tint = Color.White
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_favorite),
                    contentDescription = "Favorite",
                    tint = Color.White
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_list),
                    contentDescription = "List",
                    tint = Color.White
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_settings),
                    contentDescription = "Settings",
                    tint = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    MyApp()
}