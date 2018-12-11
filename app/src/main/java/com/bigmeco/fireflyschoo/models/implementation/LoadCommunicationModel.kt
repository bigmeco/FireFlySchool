package com.bigmeco.fireflyschoo.models.implementation

import android.util.Log
import com.bigmeco.fireflyschoo.data.InfoPojo
import com.bigmeco.fireflyschoo.models.contracts.ILoadCommunicationModel
import com.google.firebase.firestore.FirebaseFirestore

class LoadCommunicationModel:ILoadCommunicationModel {
    override fun loadInfo(response: (infoPojos: InfoPojo) -> Unit) {
        val fireStoreDataBase = FirebaseFirestore.getInstance()
        fireStoreDataBase.collection("info").document("share").get().addOnCompleteListener {
            Log.d("cscsdcscsdcsdcs",it.result.toString())
        val infoPojos:InfoPojo = it.result!!.toObject(InfoPojo::class.java)!!
            response.invoke(infoPojos)
        }

    }

}