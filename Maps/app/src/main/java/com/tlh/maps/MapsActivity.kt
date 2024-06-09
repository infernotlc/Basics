package com.tlh.maps

import android.content.ContentValues.TAG
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.tlh.maps.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val galata = LatLng(41.0260178, 28.976274)
        mMap.addMarker(MarkerOptions().position(galata).title("Galata Kulesi"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(galata, 13f))

        val karakoy = LatLng(41.0258559, 28.9723472)
        mMap.addMarker(MarkerOptions().position(karakoy).title("Karakoy"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(karakoy, 13f))

        mMap.setOnInfoWindowClickListener {
            Log.d(TAG, it.id)
        }
            mMap.setOnInfoWindowClickListener {
                if (it.id == "m0") {
                 val url = "https://maps.app.goo.gl/UCSoqM3tVuGQHrZx5"
                    val i =Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    startActivity(i)

                } else if (it.id == "m1") {
              val gsm="sms:5555555555"
                    val i =Intent(Intent.ACTION_SENDTO, Uri.parse(gsm))
                    i.putExtra("sms_body", "helelelel")
                    startActivity(i)
                }
            }

//        // Add a marker in Sydney and move the camera
//        val sydney = LatLng(-34.0, 151.0)
//        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

}