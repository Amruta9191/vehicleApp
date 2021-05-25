package com.care.turbo.vehicleapp.local

interface VehicleRepo {

    fun insertVehicles(vehicleModel: VehicleModel)
    fun getVehicles(vehicle_make : String): VehicleModel
    fun getVehicleModel(vehicle_class:String,vehicle_make: String):VehicleModel


}