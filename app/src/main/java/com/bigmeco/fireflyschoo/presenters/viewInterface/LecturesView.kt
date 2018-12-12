package com.bigmeco.fireflyschoo.presenters.viewInterface

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.bigmeco.fireflyschoo.data.CoursesPojo
import com.bigmeco.fireflyschoo.data.LecturesPojo


@StateStrategyType(AddToEndStrategy::class)
interface LecturesView: MvpView {
    fun resultLectures(resultLecturesList:  ArrayList<LecturesPojo>)
}