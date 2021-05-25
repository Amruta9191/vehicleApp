package com.care.turbo.vehicleapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.care.turbo.vehicleapp.R
import com.care.turbo.vehicleapp.activity.main.MainActivity
import com.care.turbo.vehicleapp.fragment.VehicleMakeFragment
import com.care.turbo.vehicleapp.fragment.VehicleModelFragment
import com.care.turbo.vehicleapp.viewmodel.CallBacks
import com.care.turbo.vehicleapp.viewmodel.FragmentViewModel
import kotlinx.android.synthetic.main.item_make.view.*
import java.util.ArrayList

class VehicleMakeAdapter (private val context: Context,
private val vehicleMake: ArrayList<String>,private val callBacks: CallBacks
) : RecyclerView.Adapter<VehicleMakeAdapter.MyViewHolder>() {
    lateinit var vehicleNumberViewModel: FragmentViewModel

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var vehicleMake: TextView
        var constraint : ConstraintLayout


        init {
            vehicleMake = view.vehicle_property
            constraint = view.item_make_constraint
         }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VehicleMakeAdapter.MyViewHolder {
// create a new view
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_make, parent, false)
        // set the view's size, margins, paddings and layout parameters
        return MyViewHolder(view)    }

    override fun onBindViewHolder(holder: VehicleMakeAdapter.MyViewHolder, position: Int) {
        var positionObj = vehicleMake.get(position)
        holder.vehicleMake.text = positionObj


        holder.constraint.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                 callBacks.onItemClicked(holder.vehicleMake.text.toString())
                var obj = context as MainActivity
                obj.supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container,
                    VehicleModelFragment()
                ).addToBackStack(null).commit()
             }
        })

    }

    override fun getItemCount(): Int {
       return vehicleMake.size
     }


}