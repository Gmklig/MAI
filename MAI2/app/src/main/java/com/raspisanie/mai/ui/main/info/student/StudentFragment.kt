package com.raspisanie.mai.ui.main.info.student

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.raspisanie.mai.R
import com.raspisanie.mai.common.base.BaseFragment
import com.raspisanie.mai.extesions.addSystemBottomPadding
import com.raspisanie.mai.models.human.StudentHuman
import kotlinx.android.synthetic.main.fragment_student.*
import kotlinx.android.synthetic.main.fragment_timetable.include_toolbar
import kotlinx.android.synthetic.main.layout_toolbar.view.*

class StudentFragment : BaseFragment(R.layout.fragment_student), MvpView {

    @InjectPresenter
    lateinit var presenter: StudentPresenter

    private val adapter by lazy { StudentAdapter() }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setTittleToolBar(include_toolbar, R.string.student_title, R.drawable.ic_arrow_back, 0, 0)
        include_toolbar.btnClose.setOnClickListener {
            onBackPressed()
        }

        adapter.addAll(createList())

        with(rvStudent) {
            addSystemBottomPadding()
            adapter = this@StudentFragment.adapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    fun createList(): MutableList<StudentHuman> {
        return mutableListOf(
            StudentHuman(
                name = "Волонтерский центр",
                location = "Волоколамское ш., д. 4, корп. 20 (Гук зона А), комн.219",
                phoneNumber = "+7 916 372-71-35"
            ),
            StudentHuman(
                name = "Волонтерский центр",
                location = "Волоколамское ш., д. 4, корп. 20 (Гук зона А), комн.219",
                phoneNumber = "+7 916 372-71-35"
            ),
            StudentHuman(
                name = "Волонтерский центр",
                location = "Волоколамское ш., д. 4, корп. 20 (Гук зона А), комн.219",
                phoneNumber = "+7 916 372-71-35"
            )
        )
    }

    override fun onBackPressed() {
        presenter.back()
    }
}