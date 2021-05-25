package com.care.turbo.vehicleapp.fragment

import androidx.lifecycle.ViewModel
import com.care.turbo.vehicleapp.remote.AppApiHelper
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import org.json.JSONArray

class VehicleMakeViewModel:ViewModel() {

    var disposable = CompositeDisposable()
    var apihelper = AppApiHelper()


    fun wheelerCall(vehicleClass:String): Observable<JSONArray> {
        return apihelper.doMakeWheelerCall(vehicleClass)
    }
}