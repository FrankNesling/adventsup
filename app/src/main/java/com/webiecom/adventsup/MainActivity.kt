package com.webiecom.adventsup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.webiecom.adventsup.ui.theme.AdventsUpTheme
import com.webiecom.adventsup.ui.theme.Red

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdventsUpTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Red
                ) {
                    AdventsPager()
                }
            }
        }
    }
}
