package com.example.labo7.database.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.labo7.database.entities.GuitREpo
import com.example.labo7.database.repositorios.GuitREpoRepositorio
import com.example.labo7.database.roomdb
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GuitREpoNewmodel (app:Application): AndroidViewModel(app){

    private var repository: GuitREpoRepositorio

    init {
        val repoDao = roomdb.getInstance(app).repoDao()
        repository= GuitREpoRepositorio((repoDao))
    }

    fun getAll():LiveData<List<GuitREpo>> = repository.getAll()

    fun insert(repo:GuitREpo)=viewModelScope
        .launch(Dispatchers.IO){
        repository.insert(repo)
    }



}