package com.webiecom.adventsup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.webiecom.adventsup.ui.theme.Green
import com.webiecom.adventsup.ui.theme.White


data class AdventsContent(
    val title: String,
    val text: String,
    val imageRes: Int? = null,
)
@Composable
fun DayPage(content: AdventsContent) {

    val image = painterResource(R.drawable._07_10_2024_21_55_18)


    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Title
        Spacer(Modifier.height(96.dp))
        Text(
            text = content.title,
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
        Image(
            painter = image,
            contentDescription = null   // for accessibility
        )
    }
}