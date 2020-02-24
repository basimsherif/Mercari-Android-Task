package com.basim.mercari.ui.product

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.persistence.room.Room
import android.content.Context
import com.basim.mercari.data.model.database.AppDatabase

class ProductViewModelFactory(private val context: Context, private val category: String) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductListViewModel::class.java)) {
            val db = Room.databaseBuilder(context, AppDatabase::class.java, "product").build()
            @Suppress("UNCHECKED_CAST")
            return ProductListViewModel(category, db.productDao()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }

}
