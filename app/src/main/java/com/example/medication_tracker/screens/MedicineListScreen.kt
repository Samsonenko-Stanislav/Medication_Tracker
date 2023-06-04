package com.example.medication_tracker.screens


import MedicineViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState

@Composable
fun MedicineListScreen(viewModel: MedicineViewModel) {
    val medicines by viewModel.medicines.observeAsState(emptyList())

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Список лекарств") })
        }
    ) {
        Column {
            for (medicine in medicines) {
                MedicineListItem(medicine, viewModel)
                Divider()
            }
        }
    }
}
