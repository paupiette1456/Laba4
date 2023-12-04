package com.paupiette.laba4.ui.tasks

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Preview(showSystemUi = true)
@Composable
fun AsyncFunctionWithToast() {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)) {
        Column {
            Button(
                onClick = {
                    coroutineScope.launch {
                        val asyncResult = executeAsyncTask()
                        showToast(context, asyncResult)
                    }
                },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Запустить асинхронную задачу")
            }
        }
    }

}

suspend fun executeAsyncTask(): String {
    delay(3000)
    return "Hello, world!"
}

fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}