package com.basim.mercari.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Class which provides a model for main category
 * @constructor Sets all properties of the post
 * @property name the name of main category
 * @property data the URL for main category
 */
@Entity
data class Category(
    @field:PrimaryKey
    val name : String,
    val data : String)