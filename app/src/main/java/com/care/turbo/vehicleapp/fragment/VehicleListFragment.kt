package com.care.turbo.vehicleapp.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.care.turbo.vehicleapp.R
import com.care.turbo.vehicleapp.activity.main.MainActivity
import com.care.turbo.vehicleapp.adapter.VehicleListAdapter
import com.care.turbo.vehicleapp.local.VehicleList
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_list.*

class VehicleListFragment : Fragment() {
    lateinit var vehicleListAdapter: VehicleListAdapter
    lateinit var makeArray: ArrayList<VehicleList>
    private lateinit var viewManager: RecyclerView.LayoutManager
    lateinit var float_btn_plus: FloatingActionButton

    lateinit var mainMenu: RecyclerView
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
        toolbar?.setTitle(R.string.title_veh)

         val view = inflater.inflate(R.layout.fragment_list, container, false)
        mainMenu = view.findViewById(R.id.recyclerView_fuel_type) as RecyclerView
        float_btn_plus = view.findViewById(R.id.btn_float_plus) as FloatingActionButton

        float_btn_plus.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                activity?.supportFragmentManager?.beginTransaction()?.replace(
                    R.id.fragment_container,
                    VehicleNumberFragment()
                )?.addToBackStack(null)?.commit()
            }

        })
//  activity?.btn_float_plus?.visibility = View.VISIBLE
//loadFuelTye()
        return view
    }

/*fun loadFuelTye() {
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
vehicleListAdapter = VehicleListAdapter(
   activity as Context,
   makeArray
)
mainMenu.layoutManager = viewManager
mainMenu.adapter = vehicleListAdapter
}*/


}