package com.bigmeco.fireflyschoo.presenters.presenterLogic

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.bigmeco.fireflyschoo.models.implementation.LoadAdressModel
import com.bigmeco.fireflyschoo.models.implementation.LoadCommunicationModel
import com.bigmeco.fireflyschoo.presenters.viewInterface.CommunicationView

@InjectViewState
class CommunicationPresenter : MvpPresenter<CommunicationView>() {

    fun loadInfo() {
        LoadCommunicationModel().loadInfo {
            viewState.loadInfo(it)
        }

    }

fun loadAdress() {
    LoadAdressModel().loadAdress {
        viewState.loadAdress(it)
    }

}
}