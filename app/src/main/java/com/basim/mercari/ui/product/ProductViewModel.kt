package com.basim.mercari.ui.product

import android.arch.lifecycle.MutableLiveData
import com.basim.mercari.BaseViewModel
import com.basim.mercari.data.model.Product

class ProductViewModel:BaseViewModel(){
    private val productName = MutableLiveData<String>()
    private val productId = MutableLiveData<String>()
    private val productStatus = MutableLiveData<String>()
    private val productNoOfLikes = MutableLiveData<Int>()
    private val productNoOfComments = MutableLiveData<Int>()
    private val productPrice = MutableLiveData<Double>()
    private val productImageURL = MutableLiveData<String>()

    fun bind(product: Product){
        productName.value = product.name
        productId.value = product.id
        productStatus.value = product.status
        productNoOfLikes.value = product.num_likes
        productNoOfComments.value = product.num_comments
        productPrice.value = product.price
        productImageURL.value = product.photo
    }

    fun getProductName():MutableLiveData<String>{
        return productName
    }
    fun getProductId():MutableLiveData<String>{
        return productId
    }
    fun getProductStatus():MutableLiveData<String>{
        return productStatus
    }
    fun getProductNoOfLikes():MutableLiveData<Int>{
        return productNoOfLikes
    }
    fun getProductNoOfComments():MutableLiveData<Int>{
        return productNoOfComments
    }
    fun getProductPrice():MutableLiveData<Double>{
        return productPrice
    }
    fun getProductImageURL():MutableLiveData<String>{
        return productImageURL
    }

}