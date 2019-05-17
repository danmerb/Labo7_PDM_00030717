package com.example.labo7.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.labo7.database.entities.GuitREpo


@Dao
interface GuitREpoDao {

    @Query("Select * FROM repos")
    fun getAll():LiveData<List<GuitREpo>>

    @Insert(onConflict= OnConflictStrategy.REPLACE)
    suspend fun insert(repo:GuitREpo)


    @Query("DELETE FROM repos")
    fun nukeTable()
}