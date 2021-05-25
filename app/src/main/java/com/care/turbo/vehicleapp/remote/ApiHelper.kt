package com.care.turbo.vehicleapp.remote
import com.care.turbo.vehicleapp.remote.model.request.ModelRequest
import com.care.turbo.vehicleapp.remote.model.request.WheelerRequest
import com.care.turbo.vehicleapp.remote.model.response.WheelerResponse
import io.reactivex.Observable
import io.reactivex.Single;
import org.json.JSONArray

interface ApiHelper {

    fun doMakeWheelerCall(vehicleClass:String): Observable<JSONArray>
    fun doModelWheelerCall(vehicleClass: String,vehicleMake:String): Observable<JSONArray>
}