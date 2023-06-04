package com.example.medication_tracker.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.medication_tracker.entities.Medication
import com.example.medication_tracker.MedicationDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MedicationListScreen(database: MedicationDatabase) {
    var medications by remember { mutableStateOf(listOf<Medication>()) }
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            val medicationsFromDb = database.medicationDao().getAllMedications()
            medications = medicationsFromDb
        }
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text(text = "Мои лекарства") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    coroutineScope.launch {
                        val medication = Medication(
                            name = "Название лекарства",
                            dosage = "Дозировка",
                            time = "Время приема"
                        )
                        withContext(Dispatchers.IO) {
                            database.medicationDao().insertMedication(medication)
                        }
                        medications = medications + medication
                    }
                },
                content = { Icon(Icons.Default.Add, contentDescription = "Добавить") }
            )
        }
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            medications.forEach { medication ->
                Text(
                    text = "Название: ${medication.name}",
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Дозировка: ${medication.dosage}",
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Время приема: ${medication.time}",
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Divider()
            }
        }
    }
}
