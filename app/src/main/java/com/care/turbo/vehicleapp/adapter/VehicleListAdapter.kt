package com.care.turbo.vehicleapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.care.turbo.vehicleapp.R
import com.care.turbo.vehicleapp.activity.main.MainActivity
import com.care.turbo.vehicleapp.fragment.VehicleTransmissionFragment
import com.care.turbo.vehicleapp.local.VehicleList
import kotlinx.android.synthetic.main.item_list.view.*
import kotlinx.android.synthetic.main.item_make.view.*
import kotlinx.android.synthetic.main.item_make.view.item_make_constraint
import java.util.ArrayList

class VehicleListAdapter (
    private val context: Context,
    private val vehicleFuelType: ArrayList<VehicleList>
) : RecyclerView.Adapter<VehicleListAdapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var vehicleName: TextView
        var vehicleNumber: TextView

        var constraint: ConstraintLayout


        init {
            vehicleName = view.vehicle_name
            vehicleNumber = view.vehicle_number
            constraint = view.item_make_constraint
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VehicleListAdapter.MyViewHolder {
// create a new view
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        // set the view's size, margins, paddings and layout parameters
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: VehicleListAdapter.MyViewHolder, position: Int) {
        var positionObj = vehicleFuelType.get(position)
        holder.vehicleNumber.text = positionObj.vehicleNumber
        holder.vehicleName.text = positionObj.vehicleName

        holder.constraint.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                var obj = context as MainActivity
                obj.supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container,
                    VehicleTransmissionFragment()
                ).addToBackStack(null).commit()


            }
        })

    }

    override fun getItemCount(): Int {
        return vehicleFuelType.size
    }




}