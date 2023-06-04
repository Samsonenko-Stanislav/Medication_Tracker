package com.example.medication_tracker.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.medication_tracker.entities.Medicine

@Dao
interface MedicineDao {
    @Query("SELECT * FROM medicines")
    suspend fun getAllMedicines(): List<Medicine>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMedicine(medicine: Medicine)

    @Query("UPDATE medicines SET taken = :taken WHERE id = :id")
    suspend fun updateMedicineTaken(id: Int, taken: Boolean)
}