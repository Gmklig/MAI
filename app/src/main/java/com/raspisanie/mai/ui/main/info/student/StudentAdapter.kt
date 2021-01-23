package com.raspisanie.mai.ui.main.info.student

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.raspisanie.mai.R
import com.raspisanie.mai.common.base.AbstractViewHolder
import com.raspisanie.mai.models.human.StudentHuman
import kotlinx.android.synthetic.main.item_student.view.tvLocation
import kotlinx.android.synthetic.main.item_student.view.tvTitle
import kotlinx.android.synthetic.main.item_student.view.tvNumber


class StudentAdapter : RecyclerView.Adapter<AbstractViewHolder>() {

    private val list = mutableListOf<StudentHuman>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbstractViewHolder {
        return ItemHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        )
    }

    override fun onBindViewHolder(holder: AbstractViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun addAll(list: MutableList<StudentHuman>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    inner class ItemHolder(itemView: View) : AbstractViewHolder(itemView) {

        override fun bind(data: Any?) {
            val student = data as StudentHuman
            with(itemView) {
                tvTitle.text = student.name
                tvNumber.text = student.phoneNumber
                tvLocation.text = student.location
            }
        }
    }
}