package com.webiecom.adventsup

import android.graphics.fonts.FontStyle
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.webiecom.adventsup.ui.theme.Green
import com.webiecom.adventsup.ui.theme.White


data class AdventsContent(
    val text: String
)
@Composable
fun DayPage(content: AdventsContent) {
    Text(text = content.text, fontSize = 50.sp, textAlign = TextAlign.Center, color=Green, fontWeight= FontWeight.Bold)
}