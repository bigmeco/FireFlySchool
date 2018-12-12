package com.bigmeco.fireflyschoo.models.contracts

import com.bigmeco.fireflyschoo.data.LecturesPojo

interface ILoadLecturesModel {
    fun loadingLectures(response: (newsPojos: ArrayList<LecturesPojo>) -> Unit)

}