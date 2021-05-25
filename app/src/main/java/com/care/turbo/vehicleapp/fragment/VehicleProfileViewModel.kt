package com.care.turbo.vehicleapp.fragment


import android.content.Context
import androidx.lifecycle.ViewModel
import com.care.turbo.vehicleapp.local.DatabaseClient
import com.care.turbo.vehicleapp.local.VehicleModel
import io.reactivex.Observable

class VehicleProfileViewModel: ViewModel() {

      fun saveToDb(context: Context, vehicleModel:VehicleModel): Observable<Boolean> {
          return Observable.create { e->
              DatabaseClient.getInstance(context)?.appDatabase?.vehicleDao()?.insertVehicle(vehicleModel)
          }

      }
}