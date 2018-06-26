package com.sylvainvincent.jcdecauxtest

import com.sylvainvincent.jcdecauxtest.datas.Station

internal interface MapContract {

    interface View : BaseView{
        fun displayCycleMarkers(stations: List<Station>)
    }

    interface Presenter {
        fun loadStations()
    }
}