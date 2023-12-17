package com.example.finaloncomp.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finaloncomp.R // Replace with your actual resource directory


data class ReaadyWorkoutCardInfo(
    val title: String,
    val description: String,
    val imageRes: Int // Resource ID for the image
)


// Dummy data

val readyWorkoutCards = listOf(
    WorkoutCardInfo("Abdomen", "It seems like you're interested in abdominal exercises...", R.drawable.ready1),
    WorkoutCardInfo("Abs", "Lorem Ipsum...", R.drawable.ready1),
    WorkoutCardInfo("Biceps", "Lorem Ipsum...", R.drawable.ready1),
    WorkoutCardInfo("Back", "Lorem Ipsum...", R.drawable.ready1),
    // ... other WorkoutCardInfo instances
)


@Composable
fun ReadyWorkoutCard(cardInfo: WorkoutCardInfo) {
    val painter = painterResource(id = cardInfo.imageRes)
    Column(
        modifier = Modifier
            .width(200.dp)
            .padding(8.dp)
            .background(Color.DarkGray, shape = MaterialTheme.shapes.medium)
            .padding(16.dp)
    ) {
        Image(
            painter = painter, // Use the painter obtained from the resource ID
            contentDescription = cardInfo.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .clip(MaterialTheme.shapes.medium)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = cardInfo.title,
            color = Color.White,
            style = MaterialTheme.typography.titleMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = cardInfo.description,
            color = Color.Gray,
            fontSize = 12.sp,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun ReadyWorkoutCardsRow() {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(readyWorkoutCards) { cardInfo ->
            ReadyWorkoutCard(cardInfo)
        }
    }
}