package com.example.finaloncomp.ui.theme


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finaloncomp.R

@Composable
fun MainContent2() {
    val backgroundColor = Color(0xFF282828)
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = backgroundColor // Set the background color
    ) {
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
        ) {
//            WorkoutScreen()
//            WorkoutTimeline()
            WorkoutScreenLayout()
            WorkoutStatsCard()
            ExerciseList()
            StartWorkoutButton()
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    MainContent2()
}
@Composable
fun WorkoutScreenLayout() {
    val Brown = Color(0xFF282828)
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
                .padding(horizontal = 20.dp)
            // .background(Color(0x66000000))
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    "Workout A",
                    color = Color.White,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                )
                Spacer(modifier = Modifier.height(20.dp)) //pace between the texts
            }
        }
    }
}
@Composable
fun WorkoutStatsCard() {
    Box(
        modifier = Modifier
            .padding(horizontal = 36.dp, vertical = 8.dp)
            .fillMaxWidth()
            .background(Color(0xFF414141), RoundedCornerShape(12.dp)) // Adjust the color and corner radius as needed
    ) {
        Row(
            modifier = Modifier
                .padding(all = 16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround // Distributes the children evenly with space around
        ) {
            StatItem(icon = Icons.Default.DateRange, stat = "60 Min")
            StatItem(icon = Icons.Default.Star, stat = "56 kcal")
            StatItem(icon = Icons.Default.Info, stat = "0 kg")
        }
    }
}

@Composable
fun StatItem(icon: ImageVector, stat: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.White
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = stat,
            color = Color.White
        )
    }
}
@Composable
fun ExerciseList() {
    // Static list for example purposes
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(36.dp), // Set the background color of the column
    ) {
        Divider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier.padding(bottom = 0.dp)
        )

    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 36.dp)
    ) {
        Text(
            text = "Exercises",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(36.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFF414141)) // Set the background color of the column
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(18.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.girlimage),
                contentDescription = "Exercise Image",
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(12.dp)),

                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
            ) {
                Text("Side Lateral Raise", fontWeight = FontWeight.Bold, color = Color.White)
                Spacer(modifier = Modifier.height(16.dp))
                Text("20 min", color = Color.White)
            }
            Icon(
                imageVector = Icons.Default.MoreVert, // Replace with actual icon
                contentDescription = "Options",
                tint = Color.White
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 36.dp), // Set the background color of the column
        ) {
            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.padding(bottom = 0.dp)
            )

        }
        //
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(18.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.girlimage),
                contentDescription = "Exercise Image",
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(12.dp)),

                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
            ) {
                Text("Side Lateral Raise", fontWeight = FontWeight.Bold, color = Color.White)
                Spacer(modifier = Modifier.height(16.dp))
                Text("20 min", color = Color.White)
            }
            Icon(
                imageVector = Icons.Default.MoreVert, // Replace with actual icon
                contentDescription = "Options",
                tint = Color.White
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 36.dp), // Set the background color of the column
        ) {
            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.padding(bottom = 0.dp)
            )

        }
        //

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(18.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.girlimage),
                contentDescription = "Exercise Image",
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(12.dp)),

                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
            ) {
                Text("Side Lateral Raise", fontWeight = FontWeight.Bold, color = Color.White)
                Spacer(modifier = Modifier.height(16.dp))
                Text("20 min", color = Color.White)
            }
            Icon(
                imageVector = Icons.Default.MoreVert, // Replace with actual icon
                contentDescription = "Options",
                tint = Color.White
            )
        }
    }
}
@Composable
fun StartWorkoutButton() {
    Button(
        onClick = { /* TODO: Implement click action */ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp)
            .padding(vertical = 12.dp),
        shape = RoundedCornerShape(50),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFFFA500))
    ) {
        Text("Start Workout", color = Color.White)

    }
}
