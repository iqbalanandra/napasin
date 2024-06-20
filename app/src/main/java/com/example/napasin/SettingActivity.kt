package com.example.napasin

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.text.font.FontWeight
import kotlinx.coroutines.delay

class SettingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp5(currentActivity = "SettingActivity")
        }
    }
}

@Composable
fun MyApp5(currentActivity: String) {
    Scaffold(
        bottomBar = { BottomNavigationBar4(currentActivity) }
    ) {
        MainContent4(Modifier.padding(it))
    }
}

@Composable
fun MainContent4(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Settings",
            fontFamily = poppinsFamily,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF004A76),
            modifier = Modifier.padding(top = 24.dp, bottom = 24.dp),
            fontSize = 36.sp // Add padding between items
        )

        Spacer(modifier = Modifier.height(40.dp))

        // Language Setting
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 36.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Row{
                Image(
                    painter = painterResource(id = R.drawable.group7),
                    contentDescription = "Language",
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .size(60.dp)
                )
                Text(
                    text = "Language",
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF004A76),
                    modifier = Modifier.padding(start = 36.dp),
                    fontSize = 14.sp
                )
            }

            Row{
                Text(
                    text = "English",
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF787878),
                    modifier = Modifier.padding(start = 36.dp),
                    fontSize = 10.sp
                )
                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow),
                        contentDescription = "Language",
                        tint = Color.White
                    )
                }
            }
        }

        // Notification Setting
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 36.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Row{
                Image(
                    painter = painterResource(id = R.drawable.group8),
                    contentDescription = "Notification",
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .size(60.dp)
                )
                Text(
                    text = "Notification",
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF004A76),
                    modifier = Modifier.padding(start = 36.dp),
                    fontSize = 14.sp
                )
            }

            Row{
                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow),
                        contentDescription = "Notification",
                        tint = Color.White
                    )
                }
            }
        }

        // DarkMode Setting
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 36.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Row{
                Image(
                    painter = painterResource(id = R.drawable.group9),
                    contentDescription = "Dark Mode",
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .size(60.dp)
                )
                Text(
                    text = "Dark Mode",
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF004A76),
                    modifier = Modifier.padding(start = 36.dp),
                    fontSize = 14.sp
                )
            }

            Row{
                Text(
                    text = "Off",
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF787878),
                    modifier = Modifier.padding(start = 36.dp),
                    fontSize = 10.sp
                )
                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow),
                        contentDescription = "Dark Mode",
                        tint = Color.White
                    )
                }
            }
        }

        // Microphone Setting
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 36.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Row{
                Image(
                    painter = painterResource(id = R.drawable.group10),
                    contentDescription = "Microphone",
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .size(60.dp)
                )
                Text(
                    text = "Microphone",
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF004A76),
                    modifier = Modifier.padding(start = 36.dp),
                    fontSize = 14.sp
                )
            }

            Row{
                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow),
                        contentDescription = "Microphone",
                        tint = Color.White
                    )
                }
            }
        }

        // Help Setting
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 36.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Row{
                Image(
                    painter = painterResource(id = R.drawable.group11),
                    contentDescription = "Help",
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .size(60.dp)
                )
                Text(
                    text = "Help",
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF004A76),
                    modifier = Modifier.padding(start = 36.dp),
                    fontSize = 14.sp
                )
            }

            Row{
                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow),
                        contentDescription = "Help",
                        tint = Color.White
                    )
                }
            }
        }

        Column(){
            Text(
                text = "Privacy Policy",
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.Normal,
                color = Color(0xFF004A76),
                modifier = Modifier.padding(36.dp),
                fontSize = 14.sp
            )
            Text(
                text = "Terms & Conditions",
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.Normal,
                color = Color(0xFF004A76),
                modifier = Modifier.padding(36.dp),
                fontSize = 14.sp
            )
            Text(
                text = "FAQ & Support",
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.Normal,
                color = Color(0xFF004A76),
                modifier = Modifier.padding(36.dp),
                fontSize = 14.sp
            )
        }
    }
}


@Composable
fun BottomNavigationBar4(currentActivity: String) {
    val context = LocalContext.current
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
            IconButton(onClick = {
                if (currentActivity != "HomeActivity") {
                    val navigate = Intent(context, HomeActivity::class.java)
                    context.startActivity(navigate)
                }
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_home),
                    contentDescription = "Home",
                    tint = Color.White
                )
            }
            IconButton(onClick = {
                if (currentActivity != "MeditationActivity") {
                    val navigate = Intent(context, MeditationActivity::class.java)
                    context.startActivity(navigate)
                }
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_favorite),
                    contentDescription = "Favorite",
                    tint = Color.White
                )
            }
            IconButton(onClick = {
                if (currentActivity != "GuideActivity") {
                    val navigate = Intent(context, GuideActivity::class.java)
                    context.startActivity(navigate)
                }
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_list),
                    contentDescription = "List",
                    tint = Color.White
                )
            }
            IconButton(onClick = {
                if (currentActivity != "SettingActivity") {
                    val navigate = Intent(context, SettingActivity::class.java)
                    context.startActivity(navigate)
                }
            })  {
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
fun GreetingPreview8() {
    MyApp5(currentActivity = "SettingActivity")
}