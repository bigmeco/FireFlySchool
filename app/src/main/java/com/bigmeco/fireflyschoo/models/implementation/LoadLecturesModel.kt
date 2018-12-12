package com.bigmeco.fireflyschoo.models.implementation

import android.util.Log
import com.bigmeco.fireflyschoo.data.LecturesPojo
import com.bigmeco.fireflyschoo.models.contracts.ILoadLecturesModel
import com.google.firebase.firestore.FirebaseFirestore

class LoadLecturesModel : ILoadLecturesModel {

    override fun loadingLectures(response: (lecturesPojos: ArrayList<LecturesPojo>) -> Unit) {
        Log.d("TAGgetResult", "loadingLectures")

        val fireStoreDataBase = FirebaseFirestore.getInstance()
        fireStoreDataBase.collection("lectures").get().addOnCompleteListener {
            val lecturesPojos = ArrayList<LecturesPojo>()
            for (document in it.result!!) {
                val myObject = document.toObject(LecturesPojo::class.java)
                lecturesPojos.add(myObject)
                Log.d("TAGgetResult", document.toString())
                Log.e("TAGgetResult", myObject.body)
            }
            response.invoke(lecturesPojos)
        }
    }

}
