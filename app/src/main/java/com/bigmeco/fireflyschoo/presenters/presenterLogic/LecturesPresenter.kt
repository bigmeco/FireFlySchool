package com.bigmeco.fireflyschoo.presenters.presenterLogic

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.bigmeco.fireflyschoo.models.implementation.LoadLecturesModel
import com.bigmeco.fireflyschoo.presenters.viewInterface.LecturesView


@InjectViewState
class LecturesPresenter : MvpPresenter<LecturesView>() {
    fun loadListNews() {
        LoadLecturesModel().loadingLectures{
            viewState.resultLectures(it)
        }


    }
}