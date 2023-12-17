package com.example.projectkotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.projectkotlin.ui.theme.ProjectKotlinTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

import androidx.compose.material.TopAppBar
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WorkoutScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WorkoutScreen()
}
@Composable
fun WorkoutScreen() {
    val Brown = Color(0xFF28)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brown)
    ) {
        TopAppBar(
            title = { Text("", color = Color.White) },
            navigationIcon = {
                IconButton(onClick = { /* handle back press */ }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Go back", tint = Color.White)
                }
            },
            backgroundColor = Brown
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal =28.dp)
                // .background(Color(0x66000000))
        ) {
            Image(
                painter = painterResource(id = R.drawable.girlimage),
                contentDescription = "Abdomen workout image",
                modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(22.dp)),
                contentScale = ContentScale.Crop // Ensures the image fills the width of the Box
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(25.dp)
                    .clip(RoundedCornerShape(12.dp)),
//                    .background(Color(0x66000000)) // Semi-transparent black background
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        "Abdomen",
                        color = Color.White,
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp
                        )
                    )
                    Spacer(modifier = Modifier.height(10.dp)) //pace between the texts
                    Text(
                        "It seems like you're interested in abdominal exercises, which are exercises that target the muscles in your abdomen, commonly referred to as the \"abs.\"",
                        color = Color.White,
                        style = TextStyle(
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp
                        )
                    )
                }
            }
        }
        // Your Timeline Composable goes here...
    }
}


@Composable
fun Timeline() {
    // Define your Timeline composable here
}

// Continue defining other composables as needed.
