package com.example.labo7.database.repositorios

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.labo7.database.daos.GuitREpoDao
import com.example.labo7.database.entities.GuitREpo

class GuitREpoRepositorio(private val repoDao: GuitREpoDao) {

    fun getAll(): LiveData<List<GuitREpo>> = repoDao.getAll()

    fun nuke()=repoDao.nukeTable()


    @WorkerThread
    suspend fun insert(repo:GuitREpo)=repoDao.insert(repo)


}