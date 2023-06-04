package  com.example.medication_tracker

import MedicineViewModel
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.medication_tracker.MedicineDatabase
import com.example.medication_tracker.MedicineViewModelFactory
import com.example.medication_tracker.dao.MedicineDao
import com.example.medication_tracker.screens.MedicineListScreen

class MainActivity : AppCompatActivity() {
    private lateinit var medicineDao: MedicineDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = MedicineDatabase.getDatabase(this)
        medicineDao = database.medicineDao()

        setContent {
            val viewModel: MedicineViewModel = viewModel(factory = MedicineViewModelFactory(medicineDao))
            MedicineListScreen(viewModel)
        }
    }
}




