package com.example.bantcoin

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bantcoin.ui.theme.Pink
import com.example.bantcoin.ui.theme.Purple
import com.example.bantcoin.ui.theme.Purple200


@Composable
fun Fields(
    name: String,
    onNameChange: (String) -> Unit,
    placeholders: String,
    modifier: Modifier,
) {

    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    OutlinedTextField(
        value = name,
        onValueChange = onNameChange,
        placeholder = { Text(text = placeholders) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Gray,
            disabledTextColor = Color.Transparent,
            placeholderColor = Gray,
            backgroundColor = White
        ),
        trailingIcon = {
            val image = if (passwordVisible)
                Icons.Filled.Visibility
            else Icons.Filled.VisibilityOff
            val description = if (passwordVisible) "Hide password" else "Show password"
            IconButton(
                onClick = { passwordVisible = !passwordVisible },
                modifier = Modifier.padding()
            ) {
                Icon(imageVector = image, description)
            }
},
        modifier = modifier.fillMaxWidth()
    )
}


@Composable
fun FieldsWithIcon(
    name: String,
    onNameChange: (String) -> Unit,
    placeholders: String,
    modifier: Modifier,
) {

    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    OutlinedTextField(
        value = name,
        onValueChange = onNameChange,
        trailingIcon = {
            val image = if (passwordVisible)
                Icons.Filled.Visibility
            else Icons.Filled.VisibilityOff
            val description = if (passwordVisible) "Hide password" else "Show password"
            IconButton(
                onClick = { passwordVisible = !passwordVisible },
                modifier = Modifier.padding(bottom = 60.dp)
            ) {
                Icon(imageVector = image, description)
            }

        },

        placeholder = { Text(text = placeholders) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Gray,
            disabledTextColor = Color.Transparent,
            placeholderColor = Gray,
            backgroundColor = White,
            focusedBorderColor = Purple,
            unfocusedBorderColor = Gray
        ),
        modifier = modifier.fillMaxWidth(),

        )
}


@Composable
fun TextCompose(
    text: String,
    modifier: Modifier,
    color: Color = White,
    fontWeight: FontWeight,
    fontSize: Int, textAlign: TextAlign
) {
    Text(
        text = text,
        textAlign = textAlign,
        modifier = modifier,
        color = color,
        fontWeight = fontWeight,
        fontSize = fontSize.sp
    )
}

@Composable
fun ClickText(
    text: String,
    modifier: Modifier,
    color: Color,
    fontWeight: FontWeight,
    font: Int
) {
    Text(
        text = text,
        textAlign = TextAlign.End,
        modifier = modifier,
        color = color,
        fontSize = font.sp,
        fontWeight = fontWeight
    )
}

var colorGrade = Brush.horizontalGradient(colors = listOf(
    Color(215, 3, 255),
    Color(130, 0, 255),
    Color(21, 33, 255),
    Color(0, 39, 255),
))

@Composable
fun GradientText(
    text: String,
    modifier: Modifier = Modifier,
    fontWeight: FontWeight,
    fontSize: Int,
    textAlign: TextAlign,
) {
    var colorGrade = Brush.horizontalGradient(colors = listOf(
        Color(215, 3, 255),
        Color(130, 0, 255),
        Color(21, 33, 255),
        Color(0, 39, 255),
    ))

    val sanSansFamily = FontFamily(
        Font(R.font.source_sans_regular, FontWeight.Normal),
        Font(R.font.source_sans, FontWeight.SemiBold)
    )

    Text(text = text, fontSize = fontSize.sp, fontFamily = sanSansFamily, fontWeight = FontWeight.SemiBold, modifier = Modifier
        .padding(top = 24.dp)
        .graphicsLayer(alpha = .99f)
        .drawWithCache {
            onDrawWithContent {
                drawContent()
                drawRect(colorGrade, blendMode = BlendMode.SrcAtop)
            }
        }
    )
}

@Preview
@Composable
fun gradient() {
    Column(modifier = Modifier.background(White)) {
        GradientText(text = "vjgjhgjhgg", fontWeight = FontWeight.Normal, fontSize = 20, textAlign = TextAlign.Center )

    }
}


@Composable
fun Text(
    text: String,
    modifier: Modifier = Modifier,
    fontWeight: FontWeight,
    fontSize: Int,
    textAlign: TextAlign,
    color: Color

) {
    Text(
        text = text,
        modifier = modifier,
        fontWeight = fontWeight,
        fontSize = fontSize.sp,
        textAlign = textAlign
    )
}


@Composable
fun GradientButton(
    text: String,
    gradient: Brush,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = { },
) {

    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        contentPadding = PaddingValues(),
        onClick = { onClick() },
    ) {
        Box(
            modifier = Modifier
                .height(60.dp)
                .clip(RoundedCornerShape(30.dp))
                .background(gradient)
                .then(modifier.fillMaxWidth()),
            contentAlignment = Alignment.Center,
        ) {
            Text(text = text, color = White, fontSize = 20.sp)
        }

    }
}

@Composable
fun OutlineButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = { },
) {

    Button(
        modifier = modifier.border(
            2.dp,
            colorGrade,
            androidx.compose.foundation.shape.CircleShape
        ),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        contentPadding = PaddingValues(),
        onClick = { onClick() },
    ) {
        Box(
            modifier = Modifier
                .height(60.dp)
                .clip(RoundedCornerShape(30.dp))
                .then(modifier.fillMaxWidth()),
            contentAlignment = Alignment.Center,
        ) {
            Text(text = text, color = Purple, fontSize = 20.sp)
        }

    }
}


//
//@Composable
//fun ProgressingButton(text: String, onclick: (() -> Unit)?) {
//    val progress = remember { mutableStateOf(false) }
//    (
//        onClick = {
//            progress.value = true
//            onclick?.invoke()
//        }, colors = ButtonDefaults.outlinedButtonColors(
//            backgroundColor =
//        ),modifier = Modifier
//            .fillMaxWidth()
//            .height(60.dp)
//
//            .clip(
//                RoundedCornerShape(20.dp)
//            )
//            .background(brush = horizontalGradientBrush)
//    ) {
//        Text(text = text, modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
//        Row(
//            horizontalArrangement = Arrangement.End,
//            modifier = Modifier.weight(0.1f),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            if (progress.value) {
//                CircularProgressIndicator(
//                    modifier = Modifier.padding(top = 8.dp),
//                    color = Color.White
//                )
//            }
//        }
//    }
//}

@Composable
fun OutlineButton(
    text: String,
    modifier: Modifier,
    color: Color,
    textColor: Color,
    border: BorderStroke? = ButtonDefaults.outlinedBorder,
    onclick: (() -> Unit)? = null
) {
    OutlinedButton(
        shape = RoundedCornerShape(15.dp),
        modifier = modifier, onClick = {
            onclick?.invoke()
        },
        border = border,
        colors = ButtonDefaults.outlinedButtonColors(
            backgroundColor = color
        )
    ) {
        Text(
            text = text,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center,
            style = TextStyle(fontWeight = FontWeight.Bold, color = textColor, fontSize = 18.sp)
        )
    }
}

@Composable
fun AlertDialog() {
    val showDialog = remember { mutableStateOf(false) }
    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = { showDialog.value },
            text = {
                Column(modifier = Modifier.background(color = White)) {
                    TextCompose(
                        text = "A message have been sent to your\nmail please go and verify your\nemail",
                        modifier = Modifier.fillMaxWidth(),
                        color = Color.Black,
                        fontWeight = FontWeight.Normal,
                        fontSize = 15,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    OutlineButton(text = "Continue",
                        modifier = Modifier
                            .clickable { showDialog.value }
                            .align(Alignment.CenterHorizontally),
                        color = Purple200,
                        textColor = White)
                }
            },
            buttons = {}
        )
    }
}
//data class DropDownData(val text:String,val Icon:Int)
//@Composable
//fun DropDown() {
//    var mExpanded by remember { mutableStateOf(false) }
//    val dropDown = listOf(
//        DropDownData("view all", R.drawable.chat),
//        DropDownData("Message", R.drawable.chat),
//        DropDownData("Notification", R.drawable.chat),
//        DropDownData("Follower", R.drawable.chat),
//        DropDownData("Like", R.drawable.chat),
//        DropDownData("Invite friends", R.drawable.chat),
//        DropDownData("Support", R.drawable.chat),
//    )
//}
//
//@Composable
//fun DropDownItemImp(item:DropDownData){
//    Row(modifier = Modifier.fillMaxWidth()) {
//        Icon(painter = painterResource(id = item.Icon), contentDescription = "")
//        Spacer(modifier = Modifier.width(20.dp))
//        TextCompose(
//            text = item.text,
//            modifier = Modifier,
//            fontWeight = FontWeight.Normal,
//            fontSize = 18,
//            textAlign = TextAlign.Center
//        )
//    }
//}