import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.medication_tracker.MedicineViewModel

@Composable
fun AddMedicineScreen(viewModel: MedicineViewModel, onAddComplete: () -> Unit) {
    val nameState = mutableStateOf("")
    val dosageState = mutableStateOf("")
    val timeState = mutableStateOf("")

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Добавить лекарство") })
        }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            OutlinedTextField(
                value = nameState.value,
                onValueChange = { nameState.value = it },
                label = { Text(text = "Название") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.padding(8.dp))
            OutlinedTextField(
                value = dosageState.value,
                onValueChange = { dosageState.value = it },
                label = { Text(text = "Дозировка") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.padding(8.dp))
            OutlinedTextField(
                value = timeState.value,
                onValueChange = { timeState.value = it },
                label = { Text(text = "Время приема") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Button(
                onClick = {
                    viewModel.insertMedicine(nameState.value, dosageState.value, timeState.value)
                    onAddComplete()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Добавить")
            }
        }
    }
}
