import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun FibonacciGenerator() {
    var count by remember { mutableIntStateOf(0) }
    var fibonacciNumbers by remember { mutableStateOf<List<Int>>(emptyList()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = count.takeIf { it > 0 }?.toString() ?: "",
            onValueChange = { newValue ->
                count = newValue.toIntOrNull() ?: 0
            },
            label = { Text("Введите количество чисел") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
            fibonacciNumbers = generateFibonacciSequence(count)
        }) {
            Text("Сгенерировать")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column {
            Text("Последовательность Фибоначчи:")
            fibonacciNumbers.forEach { number ->
                Text(number.toString())
            }
        }
    }
}

fun generateFibonacciSequence(count: Int): List<Int> {
    val sequence = mutableListOf<Int>()
    var a = 0
    var b = 1

    repeat(count) {
        sequence.add(a)
        val next = a + b
        a = b
        b = next
    }

    return sequence
}
