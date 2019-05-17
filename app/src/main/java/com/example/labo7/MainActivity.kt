package com.example.labo7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.labo7.adapter.ReposAdapter
import com.example.labo7.database.entities.GuitREpo
import com.example.labo7.database.viewmodel.GuitREpoNewmodel
import kotlinx.android.synthetic.main.activity_main.*
import java.security.Provider

class MainActivity : AppCompatActivity() {


    lateinit var adapter: ReposAdapter
    lateinit var viewModel: GuitREpoNewmodel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun bind(){
        adapter= ReposAdapter(ArrayList())
        viewModel= ViewModelProviders.of(this).get(GuitREpoNewmodel::class.java)
        rv_repos.apply {
            adapter = this@MainActivity.adapter
            layoutManager =LinearLayoutManager(this@MainActivity)
        }

        btn_add.setOnClickListener {
            viewModel.insert((GuitREpo(et_repo_name.text.toString())))
        }
        viewModel.getAll().observe(this, Observer {
            adapter.updateList(it)
        })
    }
}
