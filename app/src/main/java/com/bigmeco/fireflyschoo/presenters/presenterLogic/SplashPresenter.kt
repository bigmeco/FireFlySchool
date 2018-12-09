package com.bigmeco.fireflyschoo.presenters.presenterLogic

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.bigmeco.fireflyschoo.models.implementation.AuthModel
import com.bigmeco.fireflyschoo.presenters.viewInterface.SplashView

@InjectViewState
class SplashPresenter : MvpPresenter<SplashView>() {
    fun auth() {
        Log.d("AnonymousAuth", "auth")
        AuthModel().getAuth {
            viewState.auth(it)
        }
    }
}