package com.example.medication_tracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.room.Room
import com.example.medication_tracker.screens.MedicationListScreen

class MainActivity : ComponentActivity() {
    private lateinit var database: MedicationDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        database = Room.databaseBuilder(
            applicationContext,
            MedicationDatabase::class.java,
            "medication-db"
        ).build()

        setContent {
            MedicationListScreen(database)
        }
    }
}
