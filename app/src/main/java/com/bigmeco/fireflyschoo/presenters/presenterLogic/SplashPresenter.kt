package com.bigmeco.fireflyschoo.presenters.presenterLogic

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.bigmeco.fireflyschoo.models.implementation.AuthModel
import com.bigmeco.fireflyschoo.presenters.viewInterface.SplashView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

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