package com.example.bantcoin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

val sanSansFamily = FontFamily(
    Font(R.font.source_sans_regular, FontWeight.Normal),
    Font(R.font.source_sans, FontWeight.SemiBold)
)

@Composable
fun TabScreenOne() {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "You are in Token Screen",
            style = MaterialTheme.typography.h5,
            color = Color.Black,
            fontFamily = FontFamily.Monospace,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun TabScreenTwo() {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "You are in Collectibles Screen",
            style = MaterialTheme.typography.h5,
            color = Color.Black,
            fontFamily = FontFamily.Monospace,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold
        )
    }
}

var colorGrade = Brush.horizontalGradient(colors = listOf(
    Color(215, 3, 255),
    Color(130, 0, 255),
    Color(21, 33, 255),
    Color(0, 39, 255),
))

@ExperimentalPagerApi
@Composable
fun TabScreen() {
    val pagerState = rememberPagerState()
    Column(
        modifier = Modifier.background(Color.White)
    ) {
        Tabs(pagerState = pagerState)
        TabsContent(pagerState = pagerState)
    }
}

@ExperimentalPagerApi
@Composable
fun Tabs(pagerState: PagerState) {
    val list = listOf("Token", "Colectible")
    val scope = rememberCoroutineScope()

    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = Color.White,
        contentColor = Color(130, 0, 255),
        divider = {
            TabRowDefaults.Divider(
                thickness = 3.dp,
                color = Color.White
            )
        },
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier
                    .pagerTabIndicatorOffset(pagerState, tabPositions)
                    .background(colorGrade),
                height = 3.dp,
            )
        }
    ) {
        list.forEachIndexed { index, _->
            Tab(
                text = {
                    Text(
                        list[index],
                        color = if (pagerState.currentPage == index) {
                            Color(130, 0, 255)
                        } else {
                            Color(84, 93, 105)
                        },
                        fontFamily = sanSansFamily, fontWeight = FontWeight.SemiBold,
                    )
                },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )
        }
    }
}

@ExperimentalPagerApi
@Composable
fun TabsContent(pagerState: PagerState) {
    HorizontalPager(state = pagerState, count = 2) { page ->
        when(page) {
            0 -> TabScreenOne()
            1 -> TabScreenTwo()
        }
    }
}

