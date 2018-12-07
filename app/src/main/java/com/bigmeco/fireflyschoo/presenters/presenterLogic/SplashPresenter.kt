package com.bigmeco.fireflyschoo.presenters.presenterLogic

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.bigmeco.fireflyschoo.presenters.viewInterface.SplashView

@InjectViewState
class SplashPresenter : MvpPresenter<SplashView>() {
    fun auth() {
        viewState.auth()
    }

}