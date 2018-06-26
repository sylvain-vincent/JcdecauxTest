package com.sylvainvincent.jcdecauxtest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapActivity : AppCompatActivity(), OnMapReadyCallback, MapContract.View {
    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        val test = LatLng(48.8588377, 2.2770203)
        map.addMarker(MarkerOptions().position(test).title("Test"))
        map.moveCamera(CameraUpdateFactory.newLatLng(test))
        map.setMinZoomPreference(2F)
        map.setMaxZoomPreference(15F)
    }

    override fun displayCycleMarkers() {
    }

    fun init() {
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }
}
