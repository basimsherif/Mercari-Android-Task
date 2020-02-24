package com.basim.mercari.ui.category

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity
import com.basim.mercari.data.model.database.AppDatabase

class CategoryListViewModelFactory(private val activity: AppCompatActivity): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CategoryListViewModel::class.java)) {
            val db = Room.databaseBuilder(activity.applicationContext, AppDatabase::class.java, "category").build()
            @Suppress("UNCHECKED_CAST")
            return CategoryListViewModel(db.categoryDao()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}