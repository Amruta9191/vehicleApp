package com.care.turbo.vehicleapp.remote


import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Observable
import org.json.JSONArray


class AppApiHelper : ApiHelper {
    override fun doMakeWheelerCall(vehicleClass:String): Observable<JSONArray> =
        Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_MAKE_WHEELER+vehicleClass)
            .build()
            .jsonArrayObservable


    override fun doModelWheelerCall(vehicleClass: String,vehicleMake:String): Observable<JSONArray> =
        Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_MODEL+vehicleClass+"&make="+vehicleMake)
            .build()
            .jsonArrayObservable
}