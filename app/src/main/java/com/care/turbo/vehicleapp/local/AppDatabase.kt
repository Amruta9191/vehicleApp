package com.care.turbo.vehicleapp.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [(VehicleModel::class)],

    version = 1
)
abstract class AppDatabase:RoomDatabase() {

    abstract fun vehicleDao(): VehicleDao

}