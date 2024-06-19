package com.example.napasin

import android.os.Bundle
import android.widget.Space
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.napasin.ui.theme.NapasinTheme
import kotlinx.coroutines.delay

class GuideActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp3()
        }
    }
}

@Composable
fun MyApp3() {
    Scaffold(
        bottomBar = { BottomNavigationBar("GuideActivity") }
    ) {
        MainContent3(Modifier.padding(it))
    }
}

@Composable
fun MainContent3(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "For Your Lungs",
            fontFamily = poppinsFamily,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF004A76),
            modifier = Modifier.padding(top = 24.dp, bottom = 24.dp),
            fontSize = 36.sp // Add padding between items
        )

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.group_5),
            contentDescription = "Articel 1",
            modifier = Modifier
                    .padding(bottom = 16.dp)
                    .size(290.dp)
                    .clickable(onClick = {
                    // Handle clisck action here
                    })
        )

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.group_6),
            contentDescription = "Articel 1",
            modifier = Modifier
                .padding(bottom = 16.dp)
                .size(290.dp)
                .clickable(onClick = {
                    // Handle click action here
                })
        )

    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview6() {
    MyApp3()
}