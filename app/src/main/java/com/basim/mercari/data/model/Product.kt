package com.basim.mercari.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Class which provides a model for products
 * @constructor Sets all properties of the post
 * @property name the name of product
 * @property id unique identifier for id of the product
 * @property status sold/unsold status of the product
 * @property num_likes number of likes the product got
 * @property num_comments number of comments the product got
 * @property price price of the product
 * @property photo image URL for the product
 */
@Entity
data class Product(
    var name : String,
    @field:PrimaryKey
    val id : String,
    val status : String,
    val num_likes : Int,
    val num_comments : Int,
    val price : Double,
    val photo : String)