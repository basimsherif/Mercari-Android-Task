package com.basim.mercari.data.model

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface ProductDao {
    @get:Query("SELECT * FROM product")
    val all: List<Product>

    @Insert
    fun insertAll(vararg product: Product)
}