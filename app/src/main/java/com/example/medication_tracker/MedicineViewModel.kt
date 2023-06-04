import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.medication_tracker.dao.MedicineDao
import com.example.medication_tracker.entities.Medicine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MedicineViewModel(private val medicineDao: MedicineDao) : ViewModel() {
    val medicines = flow {
        emit(medicineDao.getAllMedicines())
    }.asLiveData()

    fun insertMedicine(name: String) {
        viewModelScope.launch {
            val medicine = Medicine(name = name)
            medicineDao.insertMedicine(medicine)
        }
    }

    fun updateMedicineTaken(id: Int, taken: Boolean) {
        viewModelScope.launch {
            medicineDao.updateMedicineTaken(id, taken)
        }
    }
}
