package com.sylvainvincent.jcdecauxtest

import android.os.Bundle
import android.util.Log

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.sylvainvincent.jcdecauxtest.datas.Station

class MapActivity : BaseActivity<MapPresenter>(MapPresenter()), OnMapReadyCallback, MapContract.View {
    private lateinit var googleMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.loadStations()
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }

    override fun initView() {
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        this.googleMap = googleMap
        val test = LatLng(48.8588377, 2.2770203)
        this.googleMap.addMarker(MarkerOptions().position(test).title("Test"))
        this.googleMap.moveCamera(CameraUpdateFactory.newLatLng(test))
        this.googleMap.setMinZoomPreference(2F)
        this.googleMap.setMaxZoomPreference(15F)
    }

    override fun displayCycleMarkers(stations : List<Station>) {
        for(station in stations) {
            this.googleMap.addMarker(MarkerOptions().position(station.position).title(station.name))
        }
    }

    override fun displayError() {
        Log.e("test", "error")
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
