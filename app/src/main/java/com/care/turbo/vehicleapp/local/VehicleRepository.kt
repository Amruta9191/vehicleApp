package com.care.turbo.vehicleapp.local

class VehicleRepository(private val vehicleDao: VehicleDao):VehicleRepo {
    override fun insertVehicles(vehicleModel: VehicleModel) {
       return vehicleDao.insertVehicle(vehicleModel)
     }

    override fun getVehicles(vehicle_make: String): VehicleModel {
        return vehicleDao.getVehicleByMake(vehicle_make)
     }

    override fun getVehicleModel(vehicle_class: String, vehicle_make: String) :VehicleModel{
        return vehicleDao.getVehicleByModel(vehicle_make,vehicle_class)
     }
}