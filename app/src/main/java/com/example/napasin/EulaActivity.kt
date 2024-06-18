package com.example.napasin

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class EulaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EulaScreen()
        }
    }
}

@Composable
fun EulaScreen() {
    val context = LocalContext.current
    // Start Container Screen
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF009FFF))
        .padding(16.dp)
    ) {
        // Icon Container (no spacing around it)
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(36.dp)) {
            IconButton(
                onClick = {
                    val navigate = Intent(context, AboutActivity::class.java)
                    context.startActivity(navigate)
                },
            ) {
                Icon(painter = painterResource(id = R.drawable.icons_back), contentDescription = null, tint = Color.White)
            }
        }

        // Rest of the content with spacing
        Column(modifier = Modifier
            .fillMaxHeight()
            .weight(1f), // This makes this Column fill the remaining space or you can use weight(1f)
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround){

            Text(
                text = "There are a few things to consider before using NAPAS.IN. We have summarized some important things here:",
                fontWeight = FontWeight.Bold,
                fontFamily = poppinsFamily,
                fontSize = 18.sp,
                color = Color.White
            )


            // Start Container each Rule
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
            ) {
                Row {
                    Box(modifier = Modifier
                        .size(50.dp)) {
                        Icon(painter = painterResource(id = R.drawable.icon_privacy), contentDescription = null, tint = Color.White)
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(
                            text = "PRIVACY",
                            fontWeight = FontWeight.Bold,
                            fontFamily = poppinsFamily,
                            fontSize = 18.sp,
                            color = Color.White
                        )

                        Text(
                            text = "We do not collect personal or other data. NAPAS.IN stores all data securely on your phone - it is never shared or transferred.",
                            fontWeight = FontWeight.Medium,
                            fontFamily = poppinsFamily,
                            fontSize = 18.sp,
                            color = Color.White
                        )
                    }
                }
            }

            // Start Container each Rule
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
            ) {
                Row {
                    Box(modifier = Modifier
                        .size(50.dp)) {
                        Icon(painter = painterResource(id = R.drawable.icon_bunga), contentDescription = null, tint = Color.White)
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(
                            text = "INTENDED USE",
                            fontWeight = FontWeight.Bold,
                            fontFamily = poppinsFamily,
                            fontSize = 18.sp,
                            color = Color.White
                        )

                        Text(
                            text = "This version of NAPAS.IN is intended for relaxation and should not be used if you feel short of breath. If you have a diagnosed health condition, talk to your doctor before using NAPAS.IN.",
                            fontWeight = FontWeight.Medium,
                            fontFamily = poppinsFamily,
                            fontSize = 18.sp,
                            color = Color.White
                        )
                    }
                }
            }

            // Start Container each Rule
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
            ) {
                Row {
                    Box(modifier = Modifier
                        .size(50.dp)) {
                        Icon(painter = painterResource(id = R.drawable.icon_alert), contentDescription = null, tint = Color.White)
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(
                            text = "IF YOU FEEL TIRED, TAKE A REST",
                            fontWeight = FontWeight.Bold,
                            fontFamily = poppinsFamily,
                            fontSize = 18.sp,
                            color = Color.White
                        )

                        Text(
                            text = "Allowing your body to recuperate can enhance your focus, productivity, and overall well-being.",
                            fontWeight = FontWeight.Medium,
                            fontFamily = poppinsFamily,
                            fontSize = 18.sp,
                            color = Color.White
                        )
                    }
                }
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                onClick = {
                    val navigate = Intent(context, BeginActivity::class.java)
                    context.startActivity(navigate)
                }) {
                Text(
                    text = "Accept",
                    fontFamily = poppinsFamily,
                    fontSize = 20.sp,
                    color = Color(0xFF009FFF),
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }

    }
    // End Container Screen
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    EulaScreen()
}