package com.basim.mercari

import android.arch.lifecycle.ViewModel
import com.basim.mercari.injection.module.DaggerViewModelInjector
import com.basim.mercari.injection.module.NetworkModule
import com.basim.mercari.injection.module.ViewModelInjector
import com.basim.mercari.ui.category.CategoryListViewModel
import com.basim.mercari.ui.product.ProductListViewModel

abstract class BaseViewModel:ViewModel(){
    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is CategoryListViewModel -> injector.inject(this)
            is ProductListViewModel -> injector.inject(this)
        }
    }
}