package com.paupiette.laba4.ui.tasks

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Preview
@Composable
fun AsyncRequest() {
    val viewModel: GetViewModel = viewModel()
    var response by remember { mutableStateOf("") }
    var fetchTrigger by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
            fetchTrigger = !fetchTrigger
        }) {
            Text("Сделать GET запрос")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Ответ:")
        Text(response)

        LaunchedEffect(fetchTrigger) {
            if (fetchTrigger) {
                val result = viewModel.executeGetRequest()
                response = result
            }
        }
    }
}