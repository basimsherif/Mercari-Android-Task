package com.basim.mercari.data.model.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.basim.mercari.data.model.Category
import com.basim.mercari.data.model.CategoryDao
import com.basim.mercari.data.model.Product
import com.basim.mercari.data.model.ProductDao

@Database(entities = [Category::class, Product::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun productDao(): ProductDao
}