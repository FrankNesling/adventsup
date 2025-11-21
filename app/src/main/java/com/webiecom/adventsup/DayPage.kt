package com.webiecom.adventsup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import com.webiecom.adventsup.ui.theme.Yellow
import kotlinx.coroutines.launch
import java.time.LocalDate


fun getDaySuffix(day: Int): String {
    return when (day) {
        1, 21 -> "st"
        2, 22 -> "nd"
        3, 23 -> "rd"
        else -> "th"
    }
}



@Composable
fun DayPage(idx: Int) {
    // Alert
    val openAlert = remember { mutableStateOf(false) }
    if (openAlert.value) {
        AlertDialog(
            onDismissRequest = { openAlert.value = false },
            title = { Text("The day has not yet come.") },
            text = { Text("Patience! December ${idx+1}${getDaySuffix(idx+1)} will come soon.") },
            confirmButton = {
                Button(onClick = { openAlert.value = false }) {
                    Text("OK")
                }
            }
        )
    }


    // image
    val name = "a${idx + 1}"
    val context = LocalContext.current
    val imageId = remember(name) {
        context.resources.getIdentifier(name, "drawable", context.packageName)
    }

    // data storage - already opened page
    val dataStorage = remember { DataStorage(context) }
    val hasBeenOpened = dataStorage.getOpened(idx)
        .collectAsState(false)  // initial value until loaded from data storage
        .value

    // open box functionality
    val scope = rememberCoroutineScope()
    val openBox: () -> Unit = {
        val currentDate = LocalDate.now()
        val day = currentDate.dayOfMonth
        val month = currentDate.monthValue

        // check for correct day
        if (idx + 1 <= day && month == 11) {
            scope.launch {
                try {
                    dataStorage.saveOpened(idx, true)
                } catch (e: Exception) {
                    println("Error saving data: ${e.message}")
                }
            }
        } else {
            openAlert.value = true
        }


    }

    // UI
    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // not yet opened
        if (!hasBeenOpened) {
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .size(200.dp)
                    .background(Yellow)
                    .padding(16.dp)
                    .clickable(onClick = openBox),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = (idx+1).toString(),
                    fontSize = 50.sp,
                    color = White
                )
            }
            Spacer(modifier = Modifier.weight(1f))
        } // opened
        else {
            // Title
            Spacer(Modifier.height(96.dp))
            Text(
                text = stringArrayResource(R.array.adventTitles)[idx],
                fontSize = 50.sp,
                textAlign = TextAlign.Center,
                color = Green,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "${idx+1}${getDaySuffix(idx+1)} December",
                fontSize = 25.sp,
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
}