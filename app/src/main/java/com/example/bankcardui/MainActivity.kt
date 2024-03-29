package com.example.bankcardui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bankcardui.ui.theme.BankCardUiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Box(
                    Modifier
                        .fillMaxSize()
                        .padding(16.dp)) {
                    BankCardUi(
                        modifier = Modifier.align(Alignment.Center),
                        baseColor = Color(0xFFFF9800),
                        cardNumber = "1234567890123456",
                        cardHolder = "Geek Convert",
                        expires = "01/30",
                        cvv = "124",
                        brand = "MASTER"
                    )
                }
            }
        }
    }
}
