package com.webiecom.adventsup

import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable

@Composable
fun AdventsPager() {

    // content
    val pages = listOf(
        AdventsContent("December 1", "Some text"),
        AdventsContent("December 2","Some text"),
        AdventsContent("December 3","Some text"),
    )

    // horizontal pager
    val pagerState = rememberPagerState(pageCount = {
        pages.size
    })

    HorizontalPager(state = pagerState) { page ->
        DayPage(pages[page])
    }
}