package com.example.napasin

import android.content.Intent
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.napasin.ui.theme.NapasinTheme

val poppinsFamily = FontFamily(
    Font(R.font.poppins, FontWeight.Normal),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_semibold, FontWeight.SemiBold),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_light, FontWeight.Light),
    Font(R.font.poppins_black, FontWeight.Black),
    Font(R.font.poppins_extrabold, FontWeight.ExtraBold)
)

val bebasFamily = FontFamily(
    Font(R.font.bebas_neue, FontWeight.Normal)
)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NapasInScreen()
        }
    }
}

@Composable
fun NapasInScreen() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF009FFF)),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(200.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Logo()
            Text(
                text = "NAPAS.IN",
                fontSize = 86.sp,
                fontWeight = FontWeight.Normal,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontFamily = bebasFamily,
                
            )
            Text(
                text = "BREATHE FREELY LIVE FULLY",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontFamily = bebasFamily,
                letterSpacing = 3.5.sp,
                lineHeight = 100.sp
            )
        }
        Spacer(modifier = Modifier.height(130.dp))
        Button(
            onClick = {
                val navigate = Intent(context, AboutActivity::class.java)
                context.startActivity(navigate)
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            modifier = Modifier
                .padding(16.dp)  // Adjust the top margin value here
                .fillMaxWidth()
                .height(46.dp)
        ) {
            Text(
                text = "Start",
                color = Color(0xFF009FFF),
                fontSize = 20.sp,
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.SemiBold
            )
        }

        ClickableText(
            text = AnnotatedString("Terms and Privacy Policy"),
            onClick = { /* TODO: Add terms and privacy policy action */ },
            modifier = Modifier.padding(bottom = 16.dp),
            style = MaterialTheme.typography.bodyMedium.copy(
                color = Color.White,
                textAlign = TextAlign.Center
            )
        )
    }
}

@Composable
fun Logo() {
    // Placeholder for logo
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = null, Modifier.size(83.dp))
}

@Preview(showBackground = true)
@Composable
fun PreviewNapasInScreen() {
    NapasInScreen()
}
