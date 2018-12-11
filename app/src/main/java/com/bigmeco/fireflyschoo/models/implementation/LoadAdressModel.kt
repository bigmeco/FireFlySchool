package com.bigmeco.fireflyschoo.models.implementation

import com.bigmeco.fireflyschoo.data.AdressPojo
import com.bigmeco.fireflyschoo.models.contracts.ILoadAdressModel
import com.google.firebase.firestore.FirebaseFirestore

class LoadAdressModel:ILoadAdressModel {
    override fun loadAdress(response: (InfoPojos: ArrayList<AdressPojo>) -> Unit) {
        val fireStoreDataBase = FirebaseFirestore.getInstance()
        fireStoreDataBase.collection("adress").get().addOnCompleteListener {
            val adressPojos = ArrayList<AdressPojo>()
            for (document in it.result!!) {
                val myObject = document.toObject(AdressPojo::class.java)
                adressPojos.add(myObject)
            }
            response.invoke(adressPojos)
        }
    }
}