package com.care.turbo.vehicleapp.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "Vehicle")

data class VehicleModel(

    @PrimaryKey(autoGenerate = true)
    var id: Int,

    @Expose
    @SerializedName("vehicle_number")
    @ColumnInfo(name = "vehicle_number")
    var vehicleNumber:String,

    @Expose
    @SerializedName("vehicle_model")
    @ColumnInfo(name = "vehicle_model")
    var vehicleModel:String,

    @Expose
    @SerializedName("fuel_type")
    @ColumnInfo(name = "fuel_type")
    var fuelType:String,

    @Expose
    @SerializedName("transmission")
    @ColumnInfo(name = "transmission")
    var transmission:String,

    @Expose
    @SerializedName("vehicle_class")
    @ColumnInfo(name = "vehicle_class")
    var vehicle_class:String,

    @Expose
    @SerializedName("vehicle_make")
    @ColumnInfo(name = "vehicle_make")
    var vehicle_make:String,




):Serializable