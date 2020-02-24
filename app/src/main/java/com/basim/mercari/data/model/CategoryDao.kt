package com.basim.mercari.data.model

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface CategoryDao {
    @get:Query("SELECT * FROM category")
    val all: List<Category>

    @Insert
    fun insertAll(vararg categories: Category)
}