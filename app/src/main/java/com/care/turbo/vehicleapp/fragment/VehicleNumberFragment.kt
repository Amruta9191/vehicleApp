package com.care.turbo.vehicleapp.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.care.turbo.vehicleapp.R
import com.care.turbo.vehicleapp.viewmodel.FragmentViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_vehicle_number.*


class VehicleNumberFragment : Fragment() {
    lateinit var vehicleNumberViewModel: FragmentViewModel
    lateinit var float_btn: FloatingActionButton
    lateinit var et_vehicle_name: EditText
    lateinit var spin_class: Spinner
      var vClass:String=""
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
        val view = inflater.inflate(R.layout.fragment_vehicle_number, container, false)
        var toolbar = activity?.toolbar
        toolbar?.setTitle(R.string.title_new_ptofile)
        //vehicleNumberViewModel = ViewModelProviders.of(this).get(VehicleNumberViewModel::class.java)
        fragmentViewModel = activity?.run {
            ViewModelProviders.of(this)[FragmentViewModel::class.java]
        } ?: throw Exception("Invalid Activity")
        et_vehicle_name = view.findViewById(R.id.et_vehicle) as EditText
        float_btn = view.findViewById(R.id.btn_float) as FloatingActionButton
        spin_class = view.findViewById(R.id.spi_vehicle_class) as Spinner
/*
        vehicleNumberViewModel = activity?.run {
            ViewModelProviders.of(this)[FragmentViewModel::class.java]
        } ?: throw Exception("Invalid Activity")*/

        spin_class.setOnItemSelectedListener(object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                val selectedItem = parent.getItemAtPosition(position).toString()
                if (selectedItem == "Select vehicle class") {
                    // do your stuff
                }
                else{
                    vClass = selectedItem
                    fragmentViewModel.setVehicleClass(selectedItem)

                }
            } // to close the onItemSelected

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        })

        float_btn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

                var name = et_vehicle_name.text.toString()

                fragmentViewModel.setVehicleClass(vClass)

                fragmentViewModel.setVehicleName(name)

                activity?.supportFragmentManager?.beginTransaction()?.replace(
                    R.id.fragment_container,
                    VehicleMakeFragment()
                )?.addToBackStack(null)?.commit()

            }

        })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
}