package com.example.napasin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class ListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyAppList()
        }
    }
}

@Composable
fun MyAppList() {
    Scaffold(
        bottomBar = { ListBottomNavigationBar() }
    ) {
        MainListContent(Modifier.padding(it))
    }
}

@Composable
fun MainListContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

    }
}


@Composable
fun ListBottomNavigationBar() {
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
fun GreetingPreview5() {
    MyAppList()
}
