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
import com.care.turbo.vehicleapp.adapter.VehicleMakeAdapter
import com.care.turbo.vehicleapp.adapter.VehicleTransmissionTypeAdapter
import com.care.turbo.vehicleapp.viewmodel.CallBacks
import com.care.turbo.vehicleapp.viewmodel.FragmentViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_vehicle_make.*

class VehicleTransmissionFragment : Fragment(),CallBacks {
    lateinit var vehicleTransmissionTypeAdapter: VehicleTransmissionTypeAdapter
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
        toolbar?.setTitle(R.string.title_trans)
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
        makeArray.add("Manual")
        makeArray.add("Automatic")
        viewManager = LinearLayoutManager(
            context,
            RecyclerView.VERTICAL,
            false
        ) as RecyclerView.LayoutManager
        vehicleTransmissionTypeAdapter = VehicleTransmissionTypeAdapter(
            activity as Context,
            makeArray,this
        )
        mainMenu.layoutManager = viewManager
        mainMenu.adapter = vehicleTransmissionTypeAdapter
    }

    override fun onItemClicked(vehicleMake: String) {
         fragmentViewModel.setVehicleTransmission(vehicleMake)
    }
}