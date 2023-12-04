import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import java.io.File

@Preview
@Composable
fun ReadWriteFile() {
    var textValue by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = textValue,
            onValueChange = { textValue = it },
            label = { Text("Введите для записи в файл") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {
                writeToFile(context, textValue)
                Toast.makeText(context, "Записано в файл", Toast.LENGTH_SHORT).show()
            }) {
                Text("Записать в файл")
            }

            Button(onClick = {
                textValue = readFromFile(context)
                Toast.makeText(context, "Прочтено из файла", Toast.LENGTH_SHORT).show()
            }) {
                Text("Прочитать из файла")
            }
        }
    }
}

private const val FILE_NAME = "sample.txt"

private fun writeToFile(context: Context, text: String) {
    val file = File(context.filesDir, FILE_NAME)
    file.writeText(text)
}

private fun readFromFile(context: Context): String {
    val file = File(context.filesDir, FILE_NAME)
    return if (file.exists()) {
        file.readText()
    } else {
        "Файл не найден"
    }
}
