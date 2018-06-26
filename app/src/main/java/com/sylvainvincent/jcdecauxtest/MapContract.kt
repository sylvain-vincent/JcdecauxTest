package com.sylvainvincent.jcdecauxtest

internal interface MapContract {

    interface View {
        fun displayCycleMarkers()
    }

    interface Presenter {
        fun loadStations()
    }
}