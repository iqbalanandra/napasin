package com.example.napasin

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.napasin.ui.theme.NapasinTheme

class BeginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BeginScreen()
        }
    }
}

@Composable
fun BeginScreen(){
    val context = LocalContext.current
//    Start Container Screen
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF009FFF))
        .padding(16.dp)
    ) {
        // Icon Container (no spacing around it)
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 36.dp)
            .height(36.dp)){
            IconButton(
                onClick = {
                    val navigate = Intent(context, EulaActivity::class.java)
                    context.startActivity(navigate)
                },
            ){
                Icon(painter = painterResource(id = R.drawable.icons_back), contentDescription = null, tint = Color.White)
            }
        }

        // Rest of the content with spacing
        Column(modifier = Modifier.padding(top = 40.dp).fillMaxHeight(), // This makes this Column fill the remaining space atau bisa pake weight(1f)
            horizontalAlignment = Alignment.CenterHorizontally) {

            Row {
                Image(painter = painterResource(id = R.drawable.hore), contentDescription = null, Modifier.size(314.dp))
            }
            Spacer(modifier = Modifier.height(30.dp))

            Column {
                Text(
                    text = "Alright, let's start your first training!",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontFamily = poppinsFamily,
                    fontSize = 20.sp,
                    textAlign =  TextAlign.Center
                )
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = "Follow the instructions from NAPAS.IN in practicing breathing, and get maximum results",
                    color = Color.White,
                    fontFamily = poppinsFamily,
                    fontSize = 16.sp,
                    textAlign =  TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.height(60.dp))

            Button(
                modifier = Modifier
                    .height(46.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                onClick = {
                    val navigate = Intent(context, HomeActivity::class.java)
                    context.startActivity(navigate)
                }
            ) {
                Text(
                    text = "Start Your Breathe!",
                    fontFamily = poppinsFamily,
                    fontSize = 20.sp,
                    color = Color(0xFF009FFF),
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
//    End Container Screen
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    BeginScreen()
}