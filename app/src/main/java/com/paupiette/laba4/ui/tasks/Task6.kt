package com.paupiette.laba4.ui.tasks

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Preview
@Composable
fun GeometricProgression() {
    var currentValue by remember { mutableIntStateOf(1) }
    var delayActive by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
            delayActive = !delayActive
        }) {
            Text(
                if (delayActive) "Стоп" else "Старт")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Текущее значение: $currentValue")

        LaunchedEffect(delayActive) {
            while (true) {
                if (delayActive) {
                    currentValue *= 2
                    delay(50)

                    if (currentValue == 0) currentValue = 1

                } else {
                    delay(100)
                }
            }
        }
    }
}
