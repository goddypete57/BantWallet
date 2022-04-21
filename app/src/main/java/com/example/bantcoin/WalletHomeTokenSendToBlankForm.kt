package com.example.bantcoin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
    val disGrade = Brush.horizontalGradient(colors = listOf(
        Color(151, 132, 243),
        Color(151, 132, 243),
        Color(151, 132, 243),
        Color(151, 132, 243),
    ))

    val sanSansFamily = FontFamily(
        Font(R.font.source_sans_regular, FontWeight.Normal),
        Font(R.font.source_sans, FontWeight.SemiBold)
    )
    val address = remember {
        mutableStateOf("")
    }

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
                    Image(painter = painterResource(id = R.drawable.back_arrow), modifier = Modifier
                        .size(16.dp)
                        .clickable { /*TODO*/ }, contentDescription = "back")
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
                .fillMaxWidth()
                .fillMaxHeight()) {
                Column(modifier = Modifier
                    .fillMaxHeight(.9f)
                    .fillMaxWidth()
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
                        .height(70.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                        Row(
                            Modifier
                                .fillMaxWidth(.8f)
                                .fillMaxHeight(), horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
                            Image(painter = painterResource(id = R.drawable.images), contentDescription = null, modifier = Modifier
                                .size(70.dp)
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
                    Spacer(modifier = Modifier.height(24.dp))
                    androidx.compose.material.Text(
                        text = "To",
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = sanSansFamily,
                        fontSize = 21.sp,
                        textAlign = TextAlign.Left,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    androidx.compose.material.Text(
                        text = "Address",
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = sanSansFamily,
                        fontSize = 21.sp,
                        modifier = Modifier.padding(start = 24.dp),
                        textAlign = TextAlign.Left,
                        color = Color(44, 58, 75)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = address.value,
                        onValueChange = {address.value = it},
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = Color(218, 222, 227),
                            focusedBorderColor = Color(130, 0, 255),
                            focusedLabelColor = Color(130, 0, 255),
                            unfocusedLabelColor = Color(218, 222, 227),
                        ),
                        trailingIcon = {
                            Image(painter = painterResource(id = R.drawable.capture), modifier = Modifier
                                .padding(start = 8.dp)
                                .size(13.333.dp)
                                .clickable { /*TODO*/ },
                                contentDescription = "back"
                            )
                        },
                        shape = RoundedCornerShape(50), placeholder = {
                            androidx.compose.material.Text(
                                text = "Search, Public Address (0x), or ENS",
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = sanSansFamily,
                                fontSize = 17.sp,
                                textAlign = TextAlign.Left,
                                color = Color(218, 222, 227),
                            )
                        }
                    )
                    Spacer(modifier = Modifier.height(13.dp))
                    Button(
                        onClick = { /*TODO*/ },
                        shape = RoundedCornerShape(50),
                        elevation = ButtonDefaults.elevation(0.dp),
                        colors = ButtonDefaults.buttonColors(Color.Transparent),
                        modifier = Modifier
                            .height(43.dp)
                            .fillMaxWidth()
                            .border(
                                brush = colorGrade,
                                shape = RoundedCornerShape(50.dp),
                                width = 3.dp
                            )
                            .background(Color.Transparent)) {
                        Text(
                            text = "Transfer Between My Accounts",
                            color = Color.White,
                            fontFamily = sanSansFamily,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp,
                            modifier = Modifier
                                .graphicsLayer(alpha = .99f)
                                .drawWithCache {
                                    onDrawWithContent {
                                        drawContent()
                                        drawRect(colorGrade, blendMode = BlendMode.SrcAtop)
                                    }
                                }
                        )
                    }
                    Spacer(modifier = Modifier.height(13.dp))
                    Divider()
                    Spacer(modifier = Modifier.height(24.dp))
                    androidx.compose.material.Text(
                        text = "Recents",
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = sanSansFamily,
                        fontSize = 21.sp,
                        textAlign = TextAlign.Left,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(13.dp))
                    LazyContent()
                    LazyContent()
                    LazyContent()
                }
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(), verticalAlignment = Alignment.CenterVertically){
                    var disabled = remember {
                        mutableStateOf(false)
                    }
                    disabled.value = address.value.isNotEmpty()
                    
                    Button(
                        onClick = {
                        },
                        shape = RoundedCornerShape(50),
                        elevation = ButtonDefaults.elevation(0.dp),
                        colors = ButtonDefaults.buttonColors(Color.Transparent),
                        modifier = Modifier
                            .clip(RoundedCornerShape(50))
                            .fillMaxWidth()
                            .background(brush = colorGrade)
                            .height(50.dp), enabled = disabled.value
                    ) {
                        Text(
                            text = "Next",
                            color = Color.White,
                            fontFamily = sanSansFamily,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 21.sp
                        )
                    }
                }
            }
        }
    )
}

@Composable
fun LazyContent() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp),
        horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            Modifier
                .fillMaxWidth(.95f)
                .fillMaxHeight(), horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(id = R.drawable.images), contentDescription = null, modifier = Modifier
                .size(70.dp)
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
                    text = "Jane Cooper",
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = sanSansFamily,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Left,
                    color = Color.Black
                )
                androidx.compose.material.Text(
                    text = "0xDA67b.....76892",
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