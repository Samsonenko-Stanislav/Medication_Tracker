package  com.example.medication_tracker

import AddMedicineScreen
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.medication_tracker.dao.MedicineDao
import com.example.medication_tracker.screens.MedicationTrackerApp
import com.example.medication_tracker.screens.MedicineListScreen

class MainActivity : AppCompatActivity() {
    private lateinit var medicineDao: MedicineDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = MedicineDatabase.getDatabase(this)
        medicineDao = database.medicineDao()

        setContent {
            MedicationTrackerApp(medicineDao)
        }
    }
}


