package com.care.turbo.vehicleapp.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.care.turbo.vehicleapp.R
import com.care.turbo.vehicleapp.adapter.VehicleFuelTypeAdapter
import com.care.turbo.vehicleapp.viewmodel.CallBacks
import com.care.turbo.vehicleapp.viewmodel.FragmentViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_vehicle_fuel_type.*

class VehicleFuelTypeFragment : Fragment(),CallBacks {
    lateinit var vehicleFuelTypeAdapter: VehicleFuelTypeAdapter
    lateinit var makeArray: ArrayList<String>
    private lateinit var viewManager: RecyclerView.LayoutManager
    lateinit var mainMenu: RecyclerView
    lateinit var fragmentViewModel: FragmentViewModel

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
        toolbar?.setTitle(R.string.title_select_fuel)
        val view = inflater.inflate(R.layout.fragment_vehicle_fuel_type, container, false)
        mainMenu = view.findViewById(R.id.recyclerView_fuel_type) as RecyclerView
        fragmentViewModel = activity?.run {
            ViewModelProviders.of(this)[FragmentViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        //activity?.btn_float?.visibility = View.GONE
        loadFuelTye()
        return view
    }

    fun loadFuelTye() {
        makeArray = ArrayList()
        makeArray.add("Petrol")
        makeArray.add("Diesel")
        makeArray.add("CNG")
        makeArray.add("Petrol + CNG")
        makeArray.add("Electric")
        makeArray.add("Hybrid")
        viewManager = LinearLayoutManager(
            context,
            RecyclerView.VERTICAL,
            false
        ) as RecyclerView.LayoutManager
        vehicleFuelTypeAdapter = VehicleFuelTypeAdapter(
            activity as Context,
            makeArray,this
        )
        mainMenu.layoutManager = viewManager
        mainMenu.adapter = vehicleFuelTypeAdapter
    }

    override fun onItemClicked(vehicleMake: String) {
        fragmentViewModel.setVehicleFuel(vehicleMake)
     }


}