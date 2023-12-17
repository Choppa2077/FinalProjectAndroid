package com.example.finaloncomp.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finaloncomp.R // Replace with your actual resource directory

@Composable
fun GreetingCard(userName: String, profilePicture: Painter) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF282828))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "Hello,",
                color = Color.White,
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = userName,
                color = Color.White,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Get ready for today's workout",
                color = Color.Gray,
                fontSize = 12.sp
            )
        }
        Image(
            painter = profilePicture,
            contentDescription = "Profile Picture",
            modifier = Modifier.size(48.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun UserProfile() {
    GreetingCard(
        userName = "Mukan",
        profilePicture = painterResource(id = R.drawable.profile_picture) // Use your actual profile picture resource
    )
}
