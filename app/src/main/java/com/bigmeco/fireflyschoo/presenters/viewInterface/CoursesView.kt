package com.bigmeco.fireflyschoo.presenters.viewInterface

import com.arellomobile.mvp.MvpView
import com.bigmeco.fireflyschoo.data.CoursesPojo
import com.bigmeco.fireflyschoo.data.NewsPojo

interface CoursesView:MvpView {
    fun loadingCourses(resultCoursesList:  ArrayList<CoursesPojo>)
}