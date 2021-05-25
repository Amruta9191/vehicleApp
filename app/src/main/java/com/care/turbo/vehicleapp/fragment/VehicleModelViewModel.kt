package com.care.turbo.vehicleapp.fragment

import androidx.lifecycle.ViewModel
import com.care.turbo.vehicleapp.remote.AppApiHelper
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import org.json.JSONArray

class VehicleModelViewModel : ViewModel() {

    var apihelper = AppApiHelper()


    fun modelCall(vehicleClass: String, vehicleMake:String): Observable<JSONArray> {
        return apihelper.doModelWheelerCall(vehicleClass,vehicleMake)
    }
}