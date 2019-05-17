package com.example.labo7.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.labo7.R
import com.example.labo7.database.entities.GuitREpo
import kotlinx.android.synthetic.main.repo_cardview.view.*

class ReposAdapter(var repos:List<GuitREpo>) : RecyclerView.Adapter<ReposAdapter.ViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ReposAdapter.ViewHolder {
        val view=LayoutInflater.from(p0.context).inflate(R.layout.repo_cardview,p0,false)
        return ViewHolder(view)
    }


    override fun getItemCount(): Int {
        return repos.size
    }

    fun updateList(newRepos:List<GuitREpo>) {
        this.repos=newRepos
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(p0: ReposAdapter.ViewHolder, p1: Int) {
        p0.bind(repos [p1])
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        fun bind(repo:GuitREpo)= with(itemView){
            tv_repo_name.text=repo.name
        }

    }


}