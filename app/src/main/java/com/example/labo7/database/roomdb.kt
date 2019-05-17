package com.example.labo7.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.labo7.database.daos.GuitREpoDao
import com.example.labo7.database.entities.GuitREpo


@Database(entities = [GuitREpo::class],version =1,exportSchema=false)
 public abstract class roomdb :RoomDatabase(){


    abstract fun repoDao(): GuitREpoDao



    companion object {
        @Volatile
        private var INSTANCE:roomdb?=null

        fun getInstance(
            context: Context
        ):roomdb{
            val tempInstance= INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }

            synchronized(this){
                val instance=Room
                    .databaseBuilder(context,roomdb::class.java,"Repo_DB")
                    .build()

                INSTANCE=instance
                return instance
            }

        }
    }



}