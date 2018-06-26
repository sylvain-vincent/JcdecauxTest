package com.sylvainvincent.jcdecauxtest

import android.support.v7.app.AppCompatActivity

abstract class BaseActivity<out P>(p : P) : AppCompatActivity() {

    protected val presenter = p

    protected abstract fun initView()

    override fun onDestroy() {

        super.onDestroy()
    }

}
