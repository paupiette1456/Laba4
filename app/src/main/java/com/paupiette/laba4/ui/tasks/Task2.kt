package com.paupiette.laba4.ui.tasks

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.*

@Preview
@Composable
fun MultipleAsyncFunctions() {
    Column {
        Button(
            onClick = {
                runAsyncTasks()
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Run Async Tasks")
        }
    }
}

suspend fun asyncTask1(): String {
    delay(2000)
    return "Async Task 1 completed"
}

suspend fun asyncTask2(): String {
    delay(3000)
    return "Async Task 2 completed"
}

suspend fun asyncTask3(): String {
    delay(1500)
    return "Async Task 3 completed"
}

fun runAsyncTasks() {
    val coroutineScope = CoroutineScope(Dispatchers.Default)
    coroutineScope.launch {
        val deferred1 = async { asyncTask1() }
        val deferred2 = async { asyncTask2() }
        val deferred3 = async { asyncTask3() }

        val result1 = deferred1.await()
        val result2 = deferred2.await()
        val result3 = deferred3.await()

        logResults(result1, result2, result3)
    }
}

fun logResults(result1: String, result2: String, result3: String) {
    println("Result 1: $result1")
    println("Result 2: $result2")
    println("Result 3: $result3")
}
