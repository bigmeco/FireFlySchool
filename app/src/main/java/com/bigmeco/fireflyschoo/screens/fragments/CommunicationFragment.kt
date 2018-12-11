package com.bigmeco.fireflyschoo.screens.fragments

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter

import com.bigmeco.fireflyschoo.R
import com.bigmeco.fireflyschoo.data.AdressPojo
import com.bigmeco.fireflyschoo.data.InfoPojo
import com.bigmeco.fireflyschoo.presenters.presenterLogic.CommunicationPresenter
import com.bigmeco.fireflyschoo.presenters.viewInterface.CommunicationView
import com.bigmeco.fireflyschoo.screens.adapters.AdressAdapter
import kotlinx.android.synthetic.main.fragment_communication.*
import android.content.Intent
import android.net.Uri


class CommunicationFragment : MvpAppCompatFragment(), CommunicationView {


    @InjectPresenter
    lateinit var communicationPresenter: CommunicationPresenter

    @ProvidePresenter
    fun provideCommunicationPresenter(): CommunicationPresenter {
        return CommunicationPresenter()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_communication, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listAdress.layoutManager = LinearLayoutManager(activity)
        communicationPresenter.loadInfo()
        communicationPresenter.loadAdress()

    }

    override fun loadAdress(it: ArrayList<AdressPojo>) {
        listAdress.adapter = AdressAdapter(it) {
        }
        Log.d("cscsdcscsdcsdcs", it.toString())

    }

    override fun loadInfo(it: InfoPojo) {
        textPhone.text = it.phone
        textInst.text = it.instagram
        textInst.setOnClickListener {view ->
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(it.instagram)
            startActivity(i)
        }
        textVk.text = it.vk
        textVk.setOnClickListener {view ->
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(it.vk)
            startActivity(i)
        }
        Log.d("cscsdcscsdcsdcs", it.instagram.toString())
        textPhone.setOnClickListener { view ->
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + it.phone))
            startActivity(intent)
        }
    }

}
