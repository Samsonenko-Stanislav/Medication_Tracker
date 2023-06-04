package com.example.medication_tracker.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.medication_tracker.entities.Medication

@Dao
interface MedicationDao {
    @Query("SELECT * FROM medications")
    suspend fun getAllMedications(): List<Medication>

    @Insert
    suspend fun insertMedication(medication: Medication)
}
