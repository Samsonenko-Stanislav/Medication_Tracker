package com.example.medication_tracker.screens
import AddMedicineScreen
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.medication_tracker.MedicineViewModel
import com.example.medication_tracker.MedicineViewModelFactory
import com.example.medication_tracker.dao.MedicineDao

@Composable
fun MedicationTrackerApp(medicineDao: MedicineDao) {
    val viewModel: MedicineViewModel = viewModel(factory = MedicineViewModelFactory(medicineDao))

    val navController = rememberNavController()

    NavHost(navController, startDestination = "medicineList") {
        composable("medicineList") {
            MedicineListScreen(viewModel) {
                navController.navigate("addMedicine")
            }
        }
        composable("addMedicine") {
            AddMedicineScreen(viewModel) {
                navController.navigate("medicineList") {
                    popUpTo("addMedicine") { inclusive = true }
                }
            }
        }
    }
}
