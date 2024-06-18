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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.napasin.ui.theme.NapasinTheme

class AboutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            aboutNapasin()
        }
    }
}

@Composable
fun aboutNapasin(){
    val context = LocalContext.current

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF009FFF))
        .padding(16.dp)
    ) {
        // Icon Container (no spacing around it)
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(36.dp)){
            IconButton(
                onClick = {
                    val navigate = Intent(context, MainActivity::class.java)
                    context.startActivity(navigate)
                },
            ){
                Icon(painter = painterResource(id = R.drawable.icons_back), contentDescription = null, tint = Color.White)}
        }

        // Rest of the content with spacing
        Column(modifier = Modifier.fillMaxHeight(), // This makes this Column fill the remaining space atau bisa pake weight(1f)
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround) {

            Row {
                Image(painter = painterResource(id = R.drawable.meditasi), contentDescription = null, Modifier.size(260.dp))
            }

            Column {
                Text(
                    text = "NAPAS.IN makes breathing an interactive & fun exercise",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(fontFamily = FontFamily.SansSerif),
                    fontSize = 20.sp,
                    textAlign =  TextAlign.Center
                )
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = "we will help you through simple training exercises that you can do every day.",
                    color = Color.White,
                    style = TextStyle(fontFamily = FontFamily.SansSerif),
                    fontSize = 20.sp,textAlign =  TextAlign.Center
                )
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                onClick = { /*TODO*/ }) {
                Text(
                    text = "Next",
                    style = TextStyle(fontFamily = FontFamily.SansSerif),
                    fontSize = 20.sp,
                    color = Color(0xFF009FFF),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    aboutNapasin()
}