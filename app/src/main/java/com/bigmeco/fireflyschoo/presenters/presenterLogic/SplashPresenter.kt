package com.bigmeco.fireflyschoo.presenters.presenterLogic

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.bigmeco.fireflyschoo.models.implementation.AuthModel
import com.bigmeco.fireflyschoo.presenters.viewInterface.SplashView
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.launch

@InjectViewState
class  SplashPresenter : MvpPresenter<SplashView>() {
    fun auth() {
val authModel= AuthModel()
        Log.d("AnonymousAuth","auth")
        GlobalScope.launch(Dispatchers.Main) {
            viewState.auth(authModel.getAuth())
        }
    }

}