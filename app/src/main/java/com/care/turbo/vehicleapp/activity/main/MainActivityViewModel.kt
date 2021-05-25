package com.care.turbo.vehicleapp.activity.main

import android.util.Log
import androidx.lifecycle.ViewModel
import com.care.turbo.vehicleapp.remote.AppApiHelper
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.json.JSONArray
import java.lang.Exception

class MainActivityViewModel  : ViewModel() {



/*
         Observable.create { e: ObservableEmitter<JSONArray> ->
             try {
             apihelper.doMakeWheelerCall()
                 e.onComplete()

             }
             catch (e:Exception){
                 Log.d("Exception",e.message)
             }

                *//* disposable.add(
                         .subscribeOn(Schedulers.io())
                         .observeOn(AndroidSchedulers.mainThread())
                         .subscribe({
                             Log.d("Patil", "" + it)
                             e.onNext(it)
                             e.onComplete()
                         }, {
                             it.message
                             e.onError(it)
                         })

                 )*//*


         }*/



}