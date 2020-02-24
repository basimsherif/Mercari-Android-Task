package com.basim.mercari.injection.module

import com.basim.mercari.ui.category.CategoryListViewModel
import com.basim.mercari.ui.product.ProductListViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {
    /**
     * Injects required dependencies into the specified CategoryListViewModel.
     * @param categoryListViewModel CategoryListViewModel in which to inject the dependencies
     */
    fun inject(categoryListViewModel: CategoryListViewModel)

    /**
     * Injects required dependencies into the specified ProductListViewModel.
     * @param productListViewModel ProductListViewModel in which to inject the dependencies
     */
    fun inject(productListViewModel: ProductListViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}