package com.care.turbo.vehicleapp.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.care.turbo.vehicleapp.R
import com.care.turbo.vehicleapp.adapter.VehicleMakeAdapter
import com.care.turbo.vehicleapp.local.VehicleModel
import com.care.turbo.vehicleapp.viewmodel.FragmentViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_vehicle_make.*
import kotlinx.android.synthetic.main.vehicle_profile.*

class VehicleProfileFragment : Fragment() {
    lateinit var fragmentViewModel: FragmentViewModel
    var data = ""
    var name =""
    var vclass = ""
    var make = ""
    var model = ""
    var fuel = ""
    var trans = ""

    lateinit var vehicleMakeViewModel: VehicleProfileViewModel
     override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var toolbar = activity?.toolbar
        toolbar?.setTitle("")
        vehicleMakeViewModel = ViewModelProviders.of(this).get(VehicleProfileViewModel::class.java)
        val view =  inflater.inflate(R.layout.vehicle_profile, container, false)
        fragmentViewModel = activity?.run {
            ViewModelProviders.of(this)[FragmentViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        fragmentViewModel.getVehicleName()?.observe(viewLifecycleOwner, Observer<String> { item ->
            // Update the UI using new item data
            model_txt.text = item
            Log.d("AMr Name", item)
            name = item


        })

        fragmentViewModel.getVehicleClass()?.observe(viewLifecycleOwner, Observer<String> { item ->
            // Update the UI using new item data
            Log.d("AMr Class", item)
            vclass = item
        })

        fragmentViewModel.getVehicleMake()?.observe(viewLifecycleOwner, Observer<String> { item ->
            // Update the UI using new item data
            Log.d("AMr Make", item)
            txt_make_r.text = item
            make = item

        })

        fragmentViewModel.getVehicleModel()?.observe(viewLifecycleOwner, Observer<String> { item ->
            // Update the UI using new item data
            Log.d("AMr Model", item)
            txt_model_r.text = item
            data = item
            model = item

        })

        fragmentViewModel.getVehicleFuel()?.observe(viewLifecycleOwner, Observer<String> { item ->
            // Update the UI using new item data
            Log.d("AMr Fuel", item)
            txt_fuel.text = item
            model_fuel.text = data+" "+item
            fuel = item
        })

        fragmentViewModel.getVehicleTransmission()?.observe(viewLifecycleOwner, Observer<String> { item ->
            // Update the UI using new item data
            Log.d("AMr transmission", item)
            txt_trans.text = item
            trans =item
        })

        var v = VehicleModel(0,name,vclass,make,model,fuel,trans)
        callDb(v)

        return view



    }

    fun callDb(v:VehicleModel){

        context?.let {
            vehicleMakeViewModel.saveToDb(it,v).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                  Log.d("Amruta","data added")
                },{
                    Log.d("Amruta","Amruta")
                })
        }
    }

}