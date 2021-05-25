package com.care.turbo.vehicleapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FragmentViewModel : ViewModel() {


    private var mVehicleName = MutableLiveData<String>()
    private var mVehicleClass = MutableLiveData<String>()
    private var mVehicleMake = MutableLiveData<String>()
    private var mVehicleModel = MutableLiveData<String>()
    private var mFuelType = MutableLiveData<String>()
    private var mTransmission = MutableLiveData<String>()

    fun setVehicleName(vehicleName: String) {
        mVehicleName.value = vehicleName
    }

    fun setVehicleClass(vehicleClass: String) {
        mVehicleClass.value = vehicleClass
    }

    fun setVehicleMake(vehicleMake: String) {
        mVehicleMake.value = vehicleMake
    }

    fun setVehicleModel(vehicleModel: String) {
        mVehicleModel.value = vehicleModel
    }

    fun setVehicleFuel(vehicleFuel: String) {
        mFuelType.value = vehicleFuel
    }

    fun setVehicleTransmission(vehicleTransmission: String) {
        mTransmission.value = vehicleTransmission
    }


    fun getVehicleName(): LiveData<String>? {
        if (mVehicleName == null) {
            mVehicleName = MutableLiveData<String>()
            getVehicleName() // it's called only once
        }
        return mVehicleName
    }

    fun getVehicleClass(): LiveData<String>? {
        if (mVehicleClass == null) {
            mVehicleClass = MutableLiveData<String>()
            getVehicleClass() // it's called only once
        }
        return mVehicleClass
    }

    fun getVehicleMake(): LiveData<String>? {
        if (mVehicleMake == null) {
            mVehicleMake = MutableLiveData<String>()
            getVehicleMake() // it's called only once
        }
        return mVehicleMake
    }

    fun getVehicleModel(): LiveData<String>? {
        if (mVehicleModel == null) {
            mVehicleModel = MutableLiveData<String>()
            getVehicleModel() // it's called only once
        }
        return mVehicleModel
    }

    fun getVehicleFuel(): LiveData<String>? {
        if (mFuelType == null) {
            mFuelType = MutableLiveData<String>()
            getVehicleFuel() // it's called only once
        }
        return mFuelType
    }

    fun getVehicleTransmission(): LiveData<String>? {
        if (mTransmission == null) {
            mTransmission = MutableLiveData<String>()
            getVehicleTransmission() // it's called only once
        }
        return mTransmission
    }
}

