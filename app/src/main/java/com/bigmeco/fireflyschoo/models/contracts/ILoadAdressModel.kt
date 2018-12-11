package com.bigmeco.fireflyschoo.models.contracts

import com.bigmeco.fireflyschoo.data.AdressPojo

interface ILoadAdressModel {
    fun loadAdress(response: (InfoPojos: ArrayList<AdressPojo>) -> Unit)
}