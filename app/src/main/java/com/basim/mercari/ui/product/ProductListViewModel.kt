package com.basim.mercari.ui.product

import android.arch.lifecycle.MutableLiveData
import android.view.View
import com.basim.mercari.BaseViewModel
import com.basim.mercari.R
import com.basim.mercari.data.model.ApiInterface
import com.basim.mercari.data.model.Product
import com.basim.mercari.data.model.ProductDao
import com.basim.mercari.utils.idlingresource.EspressoIdlingResource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ProductListViewModel(val mCategory: String, private val productDao: ProductDao):BaseViewModel(){

    @Inject
    lateinit var apiInterface: ApiInterface

    private lateinit var subscription: Disposable
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage:MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadProducts() }
    val productListAdapter: ProductListAdapter = ProductListAdapter()


    init {
        loadProducts()
    }

    fun loadProducts(){
        subscription = apiInterface.getProducts(mCategory)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveProductStart() }
            .doOnTerminate { onRetrieveProductFinish() }
            .subscribe( { result -> onRetrieveProductSuccess(result)},
                {onRetrieveProductError()}
            )
    }

    private fun onRetrieveProductStart(){
        EspressoIdlingResource.increment()
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrieveProductFinish(){
        EspressoIdlingResource.decrement()
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveProductSuccess(productsList:List<Product>){
        productListAdapter.updateProductList(productsList)
    }

    private fun onRetrieveProductError(){
        errorMessage.value = R.string.product_error
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }
}