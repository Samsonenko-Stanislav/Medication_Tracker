package com.example.medication_tracker

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : AppCompatActivity() {
    private val medicines = mutableStateListOf(
        Medicine("Лекарство 1"),
        Medicine("Лекарство 2"),
        Medicine("Лекарство 3")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MedicineListScreen(medicines = medicines) { medicine ->
                MedicineDetailScreen(medicine = medicine)
            }
        }
    }
}

data class Medicine(val name: String)
@Composable
fun MainContent(medicines: List<Medicine>, onItemClick: (Medicine) -> Unit) {
    MedicineListScreen(medicines = medicines, onItemClick = onItemClick)
}
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MedicineListScreen(medicines: List<Medicine>, onItemClick: (Medicine) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Список лекарств") })
        }
    ) {
        Column {
            for (medicine in medicines) {
                MedicineListItem(medicine = medicine, onItemClick = onItemClick)
                Divider()
            }
        }
    }
}

@Composable
fun MedicineListItem(medicine: Medicine, onItemClick: (Medicine) -> Unit) {
    Text(
        text = medicine.name,
        modifier = Modifier
            .padding(16.dp)
            .clickable { onItemClick(medicine) }
    )
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MedicineDetailScreen(medicine: Medicine) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Детали лекарства") })
        }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Название: ${medicine.name}")
            Spacer(modifier = Modifier.padding(8.dp))
            Button(onClick = { }) {
                Text(text = "Принять")
            }
        }
    }
}
