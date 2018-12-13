package com.bigmeco.fireflyschoo.screens.fragments

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.bigmeco.fireflyschoo.R
import com.bigmeco.fireflyschoo.data.LecturesPojo
import com.bigmeco.fireflyschoo.presenters.presenterLogic.LecturesPresenter
import com.bigmeco.fireflyschoo.presenters.viewInterface.LecturesView
import com.bigmeco.fireflyschoo.screens.activitys.FullLecturesActivity
import com.bigmeco.fireflyschoo.screens.adapters.LecturesAdapter
import kotlinx.android.synthetic.main.fragment_lectures.*


class LecturesFragment : MvpAppCompatFragment(), LecturesView {

    @InjectPresenter
    lateinit var coursesPresenter: LecturesPresenter

    @ProvidePresenter
    fun provideCoursesPresenter(): LecturesPresenter {
        return LecturesPresenter()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lectures, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lecturesList.layoutManager = LinearLayoutManager(activity)
        coursesPresenter.loadListNews()
    }

    override fun resultLectures(resultLecturesList: ArrayList<LecturesPojo>) {
        lecturesList.adapter = LecturesAdapter(resultLecturesList) {
            val intent = Intent(activity, FullLecturesActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable("value", it)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }
}
