package com.example.medication_tracker.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.medication_tracker.MedicineViewModel
import com.example.medication_tracker.entities.Medicine

@Composable
fun MedicineListItem(medicine: Medicine, viewModel: MedicineViewModel) {
    val (taken, setTaken) = remember { mutableStateOf(medicine.taken) }

    Text(
        text = medicine.name,
        modifier = Modifier
            .padding(16.dp)
            .clickable { setTaken(!taken) }
    )

    if (taken) {
        Text(text = "Принято")
    } else {
        Text(text = "Не принято")
    }

    viewModel.updateMedicineTaken(medicine.id, taken)
}