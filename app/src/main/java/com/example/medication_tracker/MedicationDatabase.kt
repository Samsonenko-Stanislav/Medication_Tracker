package com.example.medication_tracker

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.medication_tracker.dao.MedicationDao
import com.example.medication_tracker.entities.Medication

@Database(entities = [Medication::class], version = 1)
abstract class MedicationDatabase : RoomDatabase() {
    abstract fun medicationDao(): MedicationDao
}
