package com.example.medication_tracker

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.medication_tracker.dao.MedicineDao
import com.example.medication_tracker.entities.Medicine
import kotlinx.coroutines.launch

class MedicineViewModel(private val medicineDao: MedicineDao) : ViewModel() {
    private val _medicines = MutableLiveData<List<Medicine>>()
    val medicines: LiveData<List<Medicine>> get() = _medicines

    init {
        viewModelScope.launch {
            refreshMedicines()
        }
    }

    private suspend fun refreshMedicines() {
        _medicines.value = medicineDao.getAllMedicines()
    }


    fun updateMedicineTaken(id: Int, taken: Boolean) {
        viewModelScope.launch {
            medicineDao.updateMedicineTaken(id, taken)
            refreshMedicines()
        }
    }

    fun insertMedicine(name: String, dosage: String, time: String) {
        viewModelScope.launch {
            val medicine = Medicine(name = name, dosage = dosage, time = time)
            medicineDao.insertMedicine(medicine)
            refreshMedicines()
        }
    }
}
