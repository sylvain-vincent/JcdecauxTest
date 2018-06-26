package com.sylvainvincent.jcdecauxtest

import android.support.v7.app.AppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Subscription

abstract class BasePresenter<V : BaseView>(protected var view: V) {

    protected val isViewAttached: Boolean = view != null

    abstract fun detachView()

}
