package com.sylvainvincent.jcdecauxtest.datas

import com.google.android.gms.maps.model.LatLng
import com.google.gson.annotations.SerializedName
import java.util.*

data class Station(
    @SerializedName("number")
    val number: Int,
    @SerializedName("contract_name")
    val contractName: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("address")
    val address: String,
    @SerializedName("position")
    val position: LatLng,
    @SerializedName("banking")
    val banking: Boolean,
    @SerializedName("bonus")
    val bonus: Boolean,
    @SerializedName("status")
    val status: String,
    @SerializedName("bike_stands")
    val bikeStands: Int,
    @SerializedName("available_bike_stands")
    val availableBikeStands: Int,
    @SerializedName("available_bikes")
    val availableBikes: Int,
    @SerializedName("last_update")
    val lastUpdate: Date
)

