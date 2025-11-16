package com.webiecom.adventsup

import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringArrayResource

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