package com.webiecom.adventsup

import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringArrayResource
import kotlinx.coroutines.launch

@Composable
fun AdventsPager() {
    val pagesAmount = stringArrayResource(R.array.adventTitles).size

    // horizontal pager
    val pagerState = rememberPagerState(pageCount = {
        pagesAmount
    })

    HorizontalPager(state = pagerState) { idx ->
        DayPage(idx)
    }
}