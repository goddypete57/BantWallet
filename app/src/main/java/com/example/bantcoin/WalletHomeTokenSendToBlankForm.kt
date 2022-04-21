package com.example.bantcoin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview
@Composable
fun SendToToken() {
    val colorGrade = Brush.horizontalGradient(colors = listOf(
        Color(215, 3, 255),
        Color(130, 0, 255),
        Color(21, 33, 255),
        Color(0, 39, 255),
    ))

    val sanSansFamily = FontFamily(
        Font(R.font.source_sans_regular, FontWeight.Normal),
        Font(R.font.source_sans, FontWeight.SemiBold)
    )

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 24.dp),
        topBar = {
            Column(
                Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(color = Color.Transparent), verticalArrangement = Arrangement.SpaceBetween) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(96.dp)
                    .background(Color.Transparent), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Icon(painter = painterResource(id = R.drawable.back_arrow), modifier = Modifier
                        .size(13.333.dp)
                        .clickable { /*TODO*/ }
                        .graphicsLayer(alpha = .99f)
                        .drawWithCache {
                            onDrawWithContent {
                                drawContent()
                                drawRect(colorGrade, blendMode = BlendMode.SrcAtop)
                            }
                        }, contentDescription = "back")
                    Row {
                        androidx.compose.material.Text(text = "Sent to", fontSize = 24.sp, fontFamily = sanSansFamily, fontWeight = FontWeight.SemiBold)
                    }
                    Box(modifier = Modifier)
                }
                Divider()
            }
        },
        content = {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(top = 24.dp)) {
                androidx.compose.material.Text(
                    text = "From",
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = sanSansFamily,
                    fontSize = 21.sp,
                    textAlign = TextAlign.Left,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                    Row(
                        Modifier
                            .fillMaxWidth(.8f)
                            .fillMaxHeight(), horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
                        Image(painter = painterResource(id = R.drawable.images), contentDescription = null, modifier = Modifier
                            .size(80.dp)
                            .clip(
                                CircleShape
                            )
                        )
                        Spacer(modifier = Modifier.width(21.333.dp))
                        Column(modifier =  Modifier.fillMaxHeight(),
                            verticalArrangement = Arrangement.SpaceAround,
                            horizontalAlignment = Alignment.Start
                        ) {
                            androidx.compose.material.Text(
                                text = "Account 1",
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = sanSansFamily,
                                fontSize = 24.sp,
                                textAlign = TextAlign.Left,
                                color = Color.Black
                            )
                            androidx.compose.material.Text(
                                text = "9.3729 ETH",
                                fontWeight = FontWeight.Normal,
                                fontFamily = sanSansFamily,
                                fontSize = 19.sp,
                                textAlign = TextAlign.Left,
                                color = Color.Black
                            )
                        }
                    }
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {
                        Image(painter = painterResource(id = R.drawable.foward), contentDescription = null, modifier = Modifier.clickable {  } )
                    }
                }
                
                
            }
        }
    )
}