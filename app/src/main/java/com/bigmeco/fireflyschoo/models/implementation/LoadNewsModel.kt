package com.bigmeco.fireflyschoo.models.implementation

import android.util.Log
import com.bigmeco.fireflyschoo.data.NewsPojo
import com.bigmeco.fireflyschoo.models.contracts.ILoadNewsModel
import com.google.firebase.firestore.FirebaseFirestore

class LoadNewsModel : ILoadNewsModel {
    override fun loadingNews(response: (newsPojos: ArrayList<NewsPojo>) -> Unit) {

        val fireStoreDataBase = FirebaseFirestore.getInstance()
        fireStoreDataBase.collection("news").get().addOnCompleteListener {
            val newsPojos = ArrayList<NewsPojo>()
            for (document in it.result!!) {
                val myObject = document.toObject(NewsPojo::class.java)
                newsPojos.add(myObject)
                Log.d("TAGgetResult", document.toString())
                Log.e("TAGgetResult", myObject.body)
            }
            response.invoke(newsPojos)
        }
    }

}