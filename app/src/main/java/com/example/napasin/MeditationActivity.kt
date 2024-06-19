package com.example.napasin

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import android.media.MediaPlayer

class MeditationActivity : ComponentActivity() {
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp2(currentActivity = "MeditationActivity") { isPlaying ->
                if (isPlaying) {
                    startPlayback()
                } else {
                    stopPlayback()
                }
            }
        }
    }

    private fun startPlayback() {
        // Release any existing MediaPlayer instance
        mediaPlayer?.release()

        // Create a new MediaPlayer instance
        mediaPlayer = MediaPlayer.create(this, R.raw.meditation)
        mediaPlayer?.start()
    }

    private fun stopPlayback() {
        mediaPlayer?.release()
        mediaPlayer = null
    }
}

@Composable
fun MyApp2(currentActivity: String, onPlayButtonClick: (Boolean) -> Unit) {
    Scaffold(
        bottomBar = { BottomNavigationBar(currentActivity) }
    ) {
        MainContent2(Modifier.padding(it), onPlayButtonClick)
    }
}

@Composable
fun MainContent2(modifier: Modifier = Modifier, onPlayButtonClick: (Boolean) -> Unit) {
    val isPlaying = remember { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Meditation",
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF004A76),
            modifier = Modifier.padding(bottom = 24.dp),
            fontSize = 36.sp
        )

        Spacer(modifier = Modifier.height(60.dp))

        Image(
            painter = painterResource(id = if (isPlaying.value) R.drawable.stop else R.drawable.play),
            contentDescription = if (isPlaying.value) "Stop Button" else "Play Button",
            modifier = Modifier
                .padding(bottom = 16.dp)
                .clickable {
                    isPlaying.value = !isPlaying.value
                    onPlayButtonClick(isPlaying.value)
                }
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Be Comfy...",
            fontWeight = FontWeight.Normal,
            color = Color(0xFF004A76),
            modifier = Modifier.padding(bottom = 24.dp),
            fontSize = 24.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview5() {
}
