package com.bigmeco.fireflyschoo.data

import java.io.Serializable

class CoursesPojo : Serializable {
    var title: String? = null
    var body: String? = null
    var image: String? = null
    var images: ArrayList<String>? = null
    var color: String? = null
}