package com.bigmeco.fireflyschoo.presenters.presenterLogic

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.bigmeco.fireflyschoo.models.implementation.LoadCoursesModel
import com.bigmeco.fireflyschoo.presenters.viewInterface.CoursesView

@InjectViewState
class CoursesPresenter : MvpPresenter<CoursesView>() {
    fun loadListNews() {
        LoadCoursesModel().loadingCourses{
            viewState.loadingCourses(it)
        }


    }
}