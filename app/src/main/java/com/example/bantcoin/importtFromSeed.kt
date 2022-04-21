package com.example.bantcoin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bantcoin.ui.theme.Purple
import com.example.bantcoin.ui.theme.Purple200
import com.example.bantcoin.ui.theme.TextColor

@Composable
fun ImportPhrase() {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        var seedphrase by rememberSaveable { mutableStateOf("") }
        var email by rememberSaveable { mutableStateOf("") }
        var password by rememberSaveable { mutableStateOf("") }
        var confirmPassword by rememberSaveable { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.back_arrow),
                    contentDescription = "",
                    tint = Color.Unspecified
                )
                Text(
                    text = "Import From Seed",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20,
                    textAlign = TextAlign.Center, color = TextColor
                )
                Icon(
                    painter = painterResource(id = R.drawable.scan_icon),
                    contentDescription = "",
                    modifier = Modifier
                        .height(70.dp)
                        .width(70.dp),
                    tint = Color.Unspecified
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Divider(thickness = 2.dp, modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.height(30.dp))

            Row() {
                Text(
                    text = "Seed Phrase",
                    fontWeight = FontWeight.Medium,
                    fontSize = 18,
                    textAlign = TextAlign.Start,
                    color = TextColor
                )
                Spacer(modifier = Modifier.width(5.dp))
                Icon(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = "",
                    tint = Color.Unspecified
                )
            }

            FieldsWithIcon(
                name = seedphrase,
                onNameChange = { seedphrase = it },
                placeholders = "Seed phrase",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
            )
            Spacer(modifier = Modifier.height(30.dp))
            Row() {
                Text(
                    text = "New Password",
                    fontWeight = FontWeight.Medium,
                    fontSize = 18,
                    textAlign = TextAlign.Start,
                    color = TextColor
                )
                Spacer(modifier = Modifier.width(5.dp))
                Icon(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = "",
                    tint = Color.Unspecified
                )
            }
            Fields(
                name = password,
                onNameChange = { password = it },
                placeholders = "New password",
                modifier = Modifier
                    .fillMaxWidth()

            )
            Text(
                text = "must be  at least 8 charaters",
                fontWeight = FontWeight.Light,
                fontSize = 18,
                textAlign = TextAlign.Start,
                color = TextColor
            )

            Spacer(modifier = Modifier.height(30.dp))
            Row() {
                Text(
                    text = "Confirm New Password",
                    fontWeight = FontWeight.Medium,
                    fontSize = 18,
                    textAlign = TextAlign.Start,
                    color = TextColor
                )
                Spacer(modifier = Modifier.width(5.dp))
                Icon(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = "",
                    tint = Color.Unspecified
                )
            }
            Fields(
                name = password,
                onNameChange = { password = it },
                placeholders = "Confirm New password",
                modifier = Modifier
                    .fillMaxWidth()

            )
            Spacer(modifier = Modifier.height(20.dp))
            Divider(thickness = 2.dp, modifier = Modifier.fillMaxWidth())
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Sign in with Finger Print?",
                    fontWeight = FontWeight.Medium,
                    fontSize = 20,
                    textAlign = TextAlign.Start,
                    color = TextColor
                )

                val checkedState = remember { mutableStateOf(true) }
                Switch(
                    checked = checkedState.value,
                    onCheckedChange = { checkedState.value = it },
                    colors = SwitchDefaults.colors(
                        checkedTrackColor = Purple200,
                        checkedThumbColor = Color.White,
                    )
                )

            }
                Row(modifier = Modifier.fillMaxWidth()){
                    Text(
                        text = "By proceeding, you agree to these",
                        fontWeight = FontWeight.Normal,
                        fontSize = 14,
                        textAlign = TextAlign.Start,
                        color = TextColor
                    )
                    Text(
                        text = "Term and Conditions",
                        fontWeight = FontWeight.Normal,
                        fontSize = 14,
                        textAlign = TextAlign.End,
                        color = Purple
                    )
                }
                Spacer(modifier = Modifier.height(70.dp))
                GradientButton(text = "Import", gradient = colorGrade)
            }


        }
    }


@Preview
@Composable
fun Import() {
    ImportPhrase()
}
