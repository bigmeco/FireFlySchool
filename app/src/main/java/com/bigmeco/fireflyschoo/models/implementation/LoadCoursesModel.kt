package com.bigmeco.fireflyschoo.models.implementation

import android.util.Log
import com.bigmeco.fireflyschoo.data.CoursesPojo
import com.bigmeco.fireflyschoo.data.NewsPojo
import com.bigmeco.fireflyschoo.models.contracts.ILoadCoursesModel
import com.bigmeco.fireflyschoo.models.contracts.ILoadNewsModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class LoadCoursesModel : ILoadCoursesModel {
    override fun loadingCourses(response: (newsPojos: ArrayList<CoursesPojo>) -> Unit)  {

        val fireStoreDataBase = FirebaseFirestore.getInstance()
        fireStoreDataBase.collection("courses").get().addOnCompleteListener {
            val newsPojos = ArrayList<CoursesPojo>()
            for (document in it.result!!) {
                val myObject = document.toObject(CoursesPojo::class.java)
                newsPojos.add(myObject)
                Log.d("TAGgetResult", document.toString())
                Log.e("TAGgetResult", myObject.body)
            }
            response.invoke(newsPojos)
        }
    }

}