package com.example.finaloncomp.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
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
            // Use buildAnnotatedString to create a styled string
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.White)) {
                        append("Hello, ")
                    }
                    withStyle(style = SpanStyle(color = Color(255, 193, 7))) {
                        append(userName)
                    }
                },
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Get ready for today's workout",
                color = Color.Gray,
                fontSize = 14.sp
            )
        }
        Image(
            painter = profilePicture,
            contentDescription = "Profile Picture",
            modifier = Modifier.size(70.dp)
                .clip(CircleShape),
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
