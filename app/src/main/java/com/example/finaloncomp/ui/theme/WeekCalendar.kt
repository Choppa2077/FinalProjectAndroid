package com.example.finaloncomp.ui.theme

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeekCalendar() {
    val today = LocalDate.now()
    val startOfWeek = today.minusDays(today.dayOfWeek.value.toLong() - 1)
    val datesOfWeek = (0..6).map { startOfWeek.plusDays(it.toLong()) }

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(40, 40, 40)),
        horizontalArrangement = Arrangement.SpaceBetween,
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(datesOfWeek) { date ->
            DateView(
                date = date,
                isToday = date == today
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DateView(date: LocalDate, isToday: Boolean) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
    ) {
        Text(
            text = date.dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault()),
            color = Color.White,
            textAlign = TextAlign.Center
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .background(if (isToday) Color.Yellow else Color.Transparent, shape = MaterialTheme.shapes.small)
        ) {
            Text(
                text = date.dayOfMonth.toString(),
                color = if (isToday) Color.Black else Color.White,
                textAlign = TextAlign.Center
            )
        }
    }
}