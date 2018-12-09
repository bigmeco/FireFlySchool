package com.bigmeco.fireflyschoo.models.contracts

import com.bigmeco.fireflyschoo.data.CoursesPojo
import com.bigmeco.fireflyschoo.data.NewsPojo

interface ILoadCoursesModel {
    fun loadingCourses(response: (newsPojos: ArrayList<CoursesPojo>) -> Unit)

}