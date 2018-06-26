package com.sylvainvincent.jcdecauxtest

import com.sylvainvincent.jcdecauxtest.datas.Station
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MapPresenter : BasePresenter<MapActivity>(MapActivity()), MapContract.Presenter {

    lateinit var stationsDisposable : Disposable

    override fun loadStations() {
        val api = JcdecauxApi.create();
        val stationsObservable = api.getStations("Paris",
                "6f0214932072b97403bdbd1f010475de6b676564")

        stationsDisposable = stationsObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({onNext -> view.displayCycleMarkers()}, // to do
                        {onError -> view.displayError()})
    }

    override fun detachView() {
        stationsDisposable.dispose()
    }

}
