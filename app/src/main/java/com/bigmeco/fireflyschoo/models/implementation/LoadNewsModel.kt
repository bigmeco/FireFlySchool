package com.bigmeco.fireflyschoo.models.implementation

import android.util.Log
import com.bigmeco.fireflyschoo.data.NewsPojo
import com.bigmeco.fireflyschoo.models.contracts.ILoadNewsModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class LoadNewsModel : ILoadNewsModel {
    override suspend fun loadingNews(): ArrayList<NewsPojo> {
        return suspendCoroutine { continuation ->
            val fireStoreDataBase = FirebaseFirestore.getInstance()
            fireStoreDataBase.collection("news").get().addOnCompleteListener {
                val newsPojos = ArrayList<NewsPojo>()
                for (document in it.result!!) {
                    val myObject = document.toObject(NewsPojo::class.java)
                    newsPojos.add(myObject)
                    Log.d("TAGgetResult", document.toString())
                    Log.e("TAGgetResult", myObject.body)
                }
                continuation.resume(newsPojos)
            }
        }
    }

}