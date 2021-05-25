package com.care.turbo.vehicleapp.fragment

 import androidx.lifecycle.LiveData
 import androidx.lifecycle.MutableLiveData
 import androidx.lifecycle.ViewModel


class VehicleNumberViewModel:ViewModel() {
    private var mName = MutableLiveData<String>()
    fun setName(name: String) {
        mName.value = name
    }

    fun getName(): LiveData<String>? {
        if (mName == null) {
            mName = MutableLiveData<String>()
            getName() // it's called only once
        }
        return mName
    }

    fun setVehicleNumber(vehicleNumber: String){

    }
}