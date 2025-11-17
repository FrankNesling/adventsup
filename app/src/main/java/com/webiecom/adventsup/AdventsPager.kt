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



    // dummy data storage test => TODO: remove
    val context = LocalContext.current
    val dataStorage = remember { DataStorage(context) }
    val scope = rememberCoroutineScope()
    val opened = dataStorage.getOpened(1)
        .collectAsState(false)  // initial value until loaded from data storage
        .value

    LaunchedEffect(pagerState.currentPage) {
        val index = pagerState.currentPage

        if (index == 2 && !opened) {
            scope.launch {
                dataStorage.saveOpened(1, true)
            }
        }
    }
}