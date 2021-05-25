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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.care.turbo.vehicleapp.R
import com.care.turbo.vehicleapp.adapter.VehiclModelAdapter
import com.care.turbo.vehicleapp.adapter.VehicleMakeAdapter
import com.care.turbo.vehicleapp.viewmodel.CallBacks
import com.care.turbo.vehicleapp.viewmodel.FragmentViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_vehicle_model.*

class VehicleModelFragment : Fragment(),CallBacks {
    lateinit var vehicleModelViewModel: VehicleModelViewModel
    lateinit var vehicleModelAdapter: VehiclModelAdapter
    lateinit var modelArray: ArrayList<String>
    private lateinit var viewManager: RecyclerView.LayoutManager
    lateinit var fragmentViewModel: FragmentViewModel
    var vehicleClass = ""
    var vehicleMake = ""
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
        toolbar?.setTitle(R.string.title_select_model)

        fragmentViewModel = activity?.run {
            ViewModelProviders.of(this)[FragmentViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        val view = inflater.inflate(R.layout.fragment_vehicle_model, container, false)
        fragmentViewModel.getVehicleClass()?.observe(viewLifecycleOwner, Observer<String> { item ->
            // Update the UI using new item data
            vehicleClass = item
        })
        fragmentViewModel.getVehicleMake()?.observe(viewLifecycleOwner, Observer<String> { item ->
            // Update the UI using new item data
            vehicleMake = item
            callVehicleMakeApi()

        })
        return view


    }

    fun callVehicleMakeApi() {
        vehicleModelViewModel = ViewModelProviders.of(this).get(VehicleModelViewModel::class.java)

        vehicleModelViewModel.modelCall(vehicleClass,vehicleMake)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ array ->
                modelArray = ArrayList()
                for (i in 0 until array.length()) {
                    val items = array.get(i)
                    modelArray.add(items.toString())

                }
                viewManager = LinearLayoutManager(
                    activity,
                    RecyclerView.VERTICAL,
                    false
                ) as RecyclerView.LayoutManager
                vehicleModelAdapter = VehiclModelAdapter(
                    activity as Context,
                    modelArray,this
                )

                recyclerView_model.layoutManager = viewManager
                recyclerView_model.adapter = vehicleModelAdapter

            }, {
                Log.d("Exception", it.message)
            })
    }

    override fun onItemClicked(vehicleMake: String) {
         fragmentViewModel.setVehicleModel(vehicleMake)
    }
}