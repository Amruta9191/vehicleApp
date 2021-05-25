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
import com.care.turbo.vehicleapp.adapter.VehicleMakeAdapter
import com.care.turbo.vehicleapp.viewmodel.CallBacks
import com.care.turbo.vehicleapp.viewmodel.FragmentViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_vehicle_make.*
import kotlinx.android.synthetic.main.fragment_vehicle_make.view.*

class VehicleMakeFragment : Fragment(),CallBacks {
    lateinit var vehicleMakeViewModel: VehicleMakeViewModel
    lateinit var vehicleMakeAdapter: VehicleMakeAdapter
    lateinit var makeArray: ArrayList<String>
    lateinit var vehicleNumberViewModel: VehicleNumberViewModel
    private lateinit var viewManager: RecyclerView.LayoutManager
    lateinit var fragmentViewModel: FragmentViewModel
    var vehicleClass=""

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
        toolbar?.setTitle(R.string.title_select_make)
        //activity?.btn_float_plus?.visibility = View.GONE
        //activity?.btn_float?.visibility = View.GONE
        vehicleMakeViewModel = ViewModelProviders.of(this).get(VehicleMakeViewModel::class.java)


        val view = inflater.inflate(R.layout.fragment_vehicle_make, container, false)
        fragmentViewModel = activity?.run {
            ViewModelProviders.of(this)[FragmentViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
      /*  vehicleNumberViewModel = activity?.run {
            ViewModelProviders.of(this)[VehicleNumberViewModel::class.java]
        } ?: throw Exception("Invalid Activity")


        callVehicleMakeApi()*/
        fragmentViewModel.getVehicleClass()?.observe(viewLifecycleOwner, Observer<String> { item ->
            // Update the UI using new item data
            vehicleClass = item
            callVehicleMakeApi()
        })
    }

    fun callVehicleMakeApi() {
        vehicleNumberViewModel = activity?.run {
            ViewModelProviders.of(this)[VehicleNumberViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        vehicleMakeViewModel.wheelerCall(vehicleClass)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ array ->
                makeArray = ArrayList()
                for (i in 0 until array.length()) {
                    val items = array.get(i)
                    makeArray.add(items.toString())

                }
                viewManager = LinearLayoutManager(
                    activity,
                    RecyclerView.VERTICAL,
                    false
                ) as RecyclerView.LayoutManager
                vehicleMakeAdapter = VehicleMakeAdapter(
                    activity as Context,
                    makeArray,this
                )

                recyclerView_make.layoutManager = viewManager
                recyclerView_make.adapter = vehicleMakeAdapter

            }, {
                Log.d("Exception", it.message)
            })
    }

    override fun onItemClicked(vehicleMake: String) {
        fragmentViewModel.setVehicleMake(vehicleMake)
     }
}