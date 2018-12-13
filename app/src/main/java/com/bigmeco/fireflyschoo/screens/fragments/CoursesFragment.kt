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
import com.bigmeco.fireflyschoo.data.CoursesPojo
import com.bigmeco.fireflyschoo.presenters.presenterLogic.CoursesPresenter
import com.bigmeco.fireflyschoo.presenters.viewInterface.CoursesView
import com.bigmeco.fireflyschoo.screens.activitys.FullCoursesActivity
import com.bigmeco.fireflyschoo.screens.adapters.CoursesAdapter
import kotlinx.android.synthetic.main.fragment_courses.*

class CoursesFragment : MvpAppCompatFragment(), CoursesView {


    @InjectPresenter
    lateinit var coursesPresenter: CoursesPresenter

    @ProvidePresenter
    fun provideCoursesPresenter(): CoursesPresenter {
        return CoursesPresenter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_courses, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        coursesList.layoutManager = LinearLayoutManager(activity)
        coursesPresenter.loadListNews()

    }

    override fun loadingCourses(resultCoursesList: ArrayList<CoursesPojo>) {
        coursesList.adapter = CoursesAdapter(resultCoursesList) {
            val intent = Intent(activity, FullCoursesActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable("value", it)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }

}
