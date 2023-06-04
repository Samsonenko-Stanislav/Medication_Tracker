package com.example.medication_tracker.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.medication_tracker.MedicineViewModel
import com.example.medication_tracker.R
import com.example.medication_tracker.entities.Medicine

@Composable
fun MedicineListScreen(viewModel: MedicineViewModel, onAddMedicineClick: () -> Unit) {
    val medicines = viewModel.medicines.observeAsState(emptyList())

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(stringResource(R.string.screen_title_medicine_list)) })
        },
        content = {
            Column {
                if (medicines.value.isNotEmpty()) {
                    MedicineList(medicines = medicines.value)
                } else {
                    Text(text = stringResource(R.string.empty_medicine_list))
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddMedicineClick,
                content = { Icon(Icons.Default.Add, contentDescription = stringResource(R.string.add_medicine)) }
            )
        }
    )
}

@Composable
fun MedicineList(medicines: List<Medicine>) {
    // Отобразить список лекарств
    LazyColumn {
        items(medicines) { medicine ->
            Text(text = medicine.name)
        }
    }
}

@Preview
@Composable
fun PreviewMedicineListScreen() {
    val viewModel: MedicineViewModel = viewModel()
    MedicineListScreen(viewModel = viewModel, onAddMedicineClick = {})
}
