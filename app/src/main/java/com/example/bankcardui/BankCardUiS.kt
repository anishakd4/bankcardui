package com.example.bankcardui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun BankCardUi(
    modifier: Modifier = Modifier,
    baseColor: Color = Color(0xFF1252C8),
    cardNumber: String = "",
    cardHolder: String = "",
    expires: String = "",
    cvv: String = "",
    brand: String = ""
) {
    val bankCardAspectRatio = 1.586f
    Card(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(bankCardAspectRatio),
        elevation = CardDefaults.cardElevation(defaultElevation = 16.dp)
    ) {
        Box {
            BankCardBackground(baseColor = baseColor)
            BankCardNumber(cardNumber = cardNumber)
            SpaceWrapper(
                modifier = Modifier.align(Alignment.TopStart),
                space = 32.dp,
                top = true,
                left = true
            ) {
                BankCardLabelAndText(label = "card holder", text = cardHolder)
            }
            SpaceWrapper(
                modifier = Modifier.align(Alignment.BottomStart),
                space = 32.dp,
                bottom = true,
                left = true
            ) {
                Row {
                    BankCardLabelAndText(label = "expires", text = expires)
                    Spacer(modifier = Modifier.width(16.dp))
                    BankCardLabelAndText(label = "cvv", text = cvv)
                }
            }
            SpaceWrapper(
                modifier = Modifier.align(Alignment.BottomEnd),
                space = 32.dp,
                bottom = true,
                right = true
            ) {
                Text(
                    text = brand, style = TextStyle(
                        fontWeight = FontWeight.W500,
                        fontStyle = FontStyle.Italic,
                        fontSize = 22.sp,
                        letterSpacing = 1.sp,
                        color = Color.White
                    )
                )
            }
        }
    }
}

@Composable
fun BankCardBackground(baseColor: Color) {
    val colorSaturation75 = Color.LightGray
    val colorSaturation50 = Color.DarkGray
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .background(baseColor)
    ) {
        drawCircle(
            color = colorSaturation75,
            center = Offset(x = size.width * 0.2f, y = size.height * 0.6f),
            radius = size.minDimension * 0.85f
        )
        drawCircle(
            color = colorSaturation50,
            center = Offset(x = size.width * 0.1f, y = size.height * 0.3f),
            radius = size.minDimension * 0.75f
        )
    }
}

@Composable
fun BankCardNumber(cardNumber: String) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(3) {
            BankCardDotGroup()
        }
        Text(
            text = cardNumber.takeLast(4),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                letterSpacing = 1.sp,
                color = Color.White
            )
        )
    }
}

@Composable
fun BankCardDotGroup() {
    Canvas(
        modifier = Modifier.width(48.dp),
        onDraw = { // You can adjust the width as needed
            val dotRadius = 4.dp.toPx()
            val spaceBetweenDots = 8.dp.toPx()
            for (i in 0 until 4) { // Draw four dots
                drawCircle(
                    color = Color.White,
                    radius = dotRadius,
                    center = Offset(
                        x = i * (dotRadius * 2 + spaceBetweenDots) + dotRadius,
                        y = center.y
                    )
                )
            }
        })
}

@Composable
fun BankCardLabelAndText(label: String, text: String) {
    Column(
        modifier = Modifier
            .wrapContentSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label.uppercase(),
            style = TextStyle(
                fontWeight = FontWeight.W300,
                fontSize = 12.sp,
                letterSpacing = 1.sp,
                color = Color.White
            )
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = text,
            style = TextStyle(
                fontWeight = FontWeight.W400,
                fontSize = 16.sp,
                letterSpacing = 1.sp,
                color = Color.White
            )
        )
    }
}

@Composable
fun SpaceWrapper(
    modifier: Modifier = Modifier,
    space: Dp,
    top: Boolean = false,
    right: Boolean = false,
    bottom: Boolean = false,
    left: Boolean = false,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .then(if (top) Modifier.padding(top = space) else Modifier)
            .then(if (right) Modifier.padding(end = space) else Modifier)
            .then(if (bottom) Modifier.padding(bottom = space) else Modifier)
            .then(if (left) Modifier.padding(start = space) else Modifier)
    ) {
        content()
    }
}

@Composable
@Preview
fun BankCardUiPreview() {
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        BankCardUi(
            modifier = Modifier.align(Alignment.Center),
            baseColor = Color(0xFFFF9800),
            cardNumber = "1234567890123456",
            cardHolder = "Anish kumar",
            expires = "03/30",
            cvv = "123",
            brand = "Master"
        )
    }
}