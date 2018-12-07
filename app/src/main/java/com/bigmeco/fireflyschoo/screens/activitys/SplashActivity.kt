package com.bigmeco.fireflyschoo.screens.activitys

import android.content.Intent
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
        splashPresenter.auth()
    }


    override fun auth(uid: String) {
        val intent = Intent(this, NavigationActivity::class.java)
        intent.putExtra("UID", uid)
        startActivity(intent)
    }
}
