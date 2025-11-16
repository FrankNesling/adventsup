package com.webiecom.adventsup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.webiecom.adventsup.ui.theme.Green
import com.webiecom.adventsup.ui.theme.White

@Composable
fun DayPage(idx: Int) {

    val name = "a${idx+1}"
    val context = LocalContext.current
    val imageId = remember(name) {
        context.resources.getIdentifier(name, "drawable", context.packageName)
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Title
        Spacer(Modifier.height(96.dp))
        Text(
            text = stringArrayResource(R.array.adventTitles)[idx],
            fontSize = 50.sp,
            textAlign = TextAlign.Center,
            color = Green,
            fontWeight = FontWeight.Bold
        )

        // Text
        Spacer(Modifier.height(24.dp))
        Text(
            text = stringArrayResource(R.array.adventTexts)[idx],
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            color = White,
            fontWeight = FontWeight.Black
        )
        if (imageId != 0) {
            Image(
                painter = painterResource(imageId),
                contentDescription = null   // for accessibility
            )
        }
    }
}