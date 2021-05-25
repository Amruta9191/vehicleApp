package com.care.turbo.vehicleapp.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface VehicleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertVehicle(vehicle: VehicleModel)

    @Query("Select * from Vehicle WHERE vehicle_make=:vehicle_make")
    fun  getVehicleByMake(vehicle_make:String) : VehicleModel

    @Query("Select * from Vehicle WHERE vehicle_make=:vehicle_make AND vehicle_class=:vehicle_class")
    fun  getVehicleByModel(vehicle_make:String,vehicle_class:String) : VehicleModel
}