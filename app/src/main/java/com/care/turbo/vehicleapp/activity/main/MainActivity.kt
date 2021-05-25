package com.care.turbo.vehicleapp.activity.main

import android.os.Bundle
import android.renderscript.RenderScript
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.care.turbo.vehicleapp.R
import com.care.turbo.vehicleapp.fragment.VehicleListFragment
import com.care.turbo.vehicleapp.fragment.VehicleMakeFragment
import com.care.turbo.vehicleapp.fragment.VehicleNumberFragment
import com.care.turbo.vehicleapp.remote.model.request.WheelerRequest
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray


class MainActivity : AppCompatActivity() {
   lateinit var mainActivityViewModel:MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // calling the action bar
        val actionBar: ActionBar? = supportActionBar

        // showing the back button in action bar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        getSupportActionBar()?.hide();
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        /*mainActivityViewModel.wheelerCall().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d("Amruta",""+it.get(0))
            },{
               Log.d("Am",it.message)
            })*/
        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container,
            VehicleListFragment()
        ).commit()

       /* btn_float_plus.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container,
                    VehicleNumberFragment()
                ).commit()
            }

        })

        btn_float.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                mainActivityViewModel.get()
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container,
                    VehicleMakeFragment()
                ).commit()
            }

        })
*/



    }

    // this event will enable the back
    // function to the button on press
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


}