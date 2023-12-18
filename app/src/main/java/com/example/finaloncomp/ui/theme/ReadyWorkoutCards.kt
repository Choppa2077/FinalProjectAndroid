package com.example.finaloncomp.ui.theme

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.finaloncomp.dataclass.PhotoInfo
import com.example.finaloncomp.service.ApiService

@Composable
fun ReadyWorkoutCardsRow(apiService: ApiService) {
    val photos = remember { mutableStateListOf<PhotoInfo>() }
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        try {
            val photosFromApi = apiService.getPhotos()
            photos.addAll(photosFromApi)
        } catch (e: Exception) {
            Toast.makeText(context, "Failed to fetch photos", Toast.LENGTH_LONG).show()
        }
    }

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(photos) { photoInfo ->
            ReadyWorkoutCard(photoInfo)
        }
    }
}

@Composable
fun ReadyWorkoutCard(photoInfo: PhotoInfo) {
    Column(
        modifier = Modifier
            .width(200.dp)
            .padding(8.dp)
            .background(Color.DarkGray)
            .padding(16.dp)
    ) {
        Image(
            painter = rememberImagePainter(data = photoInfo.url),
            contentDescription = photoInfo.title,
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = photoInfo.title,
            color = Color.White,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}