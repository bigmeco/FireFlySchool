package com.bigmeco.fireflyschoo.screens

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.bigmeco.fireflyschoo.R
import com.bigmeco.fireflyschoo.presenters.presenterLogic.SplashPresenter
import com.bigmeco.fireflyschoo.presenters.viewInterface.SplashView

class SplashActivity : MvpAppCompatActivity(), SplashView {

    @InjectPresenter
    lateinit var splashPresenter: SplashPresenter

    @ProvidePresenter
    fun provideSplashPresenter(): SplashPresenter {
        return SplashPresenter()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.SplashTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun auth() {

    }
}
