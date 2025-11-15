package com.webiecom.adventsup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.webiecom.adventsup.ui.theme.Green
import com.webiecom.adventsup.ui.theme.White


data class AdventsContent(
    val text: String
)
@Composable
fun DayPage(content: AdventsContent) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Title
        Spacer(Modifier.height(96.dp))
        Text(
            text = content.text,
            fontSize = 50.sp,
            textAlign = TextAlign.Center,
            color = Green,
            fontWeight = FontWeight.Bold
        )

        // Text
        Spacer(Modifier.height(24.dp))
        Text(
            text = "Some longer text! Not only longer, but also greater! This text might be the greatest you have ever seen!",
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            color = White,
            fontWeight = FontWeight.Black
        )
    }
}