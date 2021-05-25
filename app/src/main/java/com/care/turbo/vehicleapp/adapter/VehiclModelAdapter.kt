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
import com.care.turbo.vehicleapp.fragment.VehicleFuelTypeFragment
import com.care.turbo.vehicleapp.fragment.VehicleModelFragment
import com.care.turbo.vehicleapp.viewmodel.CallBacks
import kotlinx.android.synthetic.main.item_make.view.*
import java.util.ArrayList
import javax.security.auth.callback.Callback

class VehiclModelAdapter(
    private val context: Context,
    private val vehicleModel: ArrayList<String>,private val callBacks: CallBacks
) : RecyclerView.Adapter<VehiclModelAdapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var vehicleModel: TextView
        var constraint: ConstraintLayout


        init {
            vehicleModel = view.vehicle_property
            constraint = view.item_make_constraint
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VehiclModelAdapter.MyViewHolder {
// create a new view

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_make, parent, false)

        // set the view's size, margins, paddings and layout parameters
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: VehiclModelAdapter.MyViewHolder, position: Int) {
        var positionObj = vehicleModel.get(position)
        holder.vehicleModel.text = positionObj

        holder.constraint.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                callBacks.onItemClicked(holder.vehicleModel.text.toString())
                var obj = context as MainActivity
                obj.supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container,
                    VehicleFuelTypeFragment()
                ).addToBackStack(null).commit()


            }
        })

    }

    override fun getItemCount(): Int {
        return vehicleModel.size
    }


}