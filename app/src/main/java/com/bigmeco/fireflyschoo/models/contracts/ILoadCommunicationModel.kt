package com.bigmeco.fireflyschoo.models.contracts

import com.bigmeco.fireflyschoo.data.InfoPojo

interface ILoadCommunicationModel {
    fun loadInfo(response: (InfoPojos: InfoPojo) -> Unit)
}