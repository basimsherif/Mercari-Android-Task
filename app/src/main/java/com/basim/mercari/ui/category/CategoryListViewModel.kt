package com.basim.mercari.ui.category

import android.arch.lifecycle.MutableLiveData
import android.view.View
import com.basim.mercari.BaseViewModel
import com.basim.mercari.R
import com.basim.mercari.data.model.ApiInterface
import com.basim.mercari.data.model.Category
import com.basim.mercari.data.model.CategoryDao
import com.basim.mercari.utils.idlingresource.EspressoIdlingResource
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class CategoryListViewModel(private val categoryDao: CategoryDao):BaseViewModel(){

    @Inject
    lateinit var apiInterface: ApiInterface
    private lateinit var subscription: Disposable
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage:MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadCategory() }
    val categoryList:MutableLiveData<List<Category>> = MutableLiveData()

    init {
        loadCategory()
    }

    fun loadCategory(){
        subscription = Observable.fromCallable { categoryDao.all }
            .concatMap {
                    dbcategoryList ->
                if(dbcategoryList.isEmpty())
                    apiInterface.getCategories().concatMap {
                            apiCategoryList -> categoryDao.insertAll(*apiCategoryList.toTypedArray())
                        Observable.just(apiCategoryList)
                    }
                else
                    Observable.just(dbcategoryList)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveCategoriesStart() }
            .doOnTerminate { onRetrieveCategoriesFinish() }
            .subscribe( { result -> onRetrieveCategoriesSuccess(result)},
                {onRetrieveCategoriesError()}
            )
    }

    private fun onRetrieveCategoriesStart(){
        EspressoIdlingResource.increment()
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrieveCategoriesFinish(){
        EspressoIdlingResource.decrement()
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveCategoriesSuccess(categoryList:List<Category>){
        this.categoryList.value = categoryList
    }

    private fun onRetrieveCategoriesError(){
        errorMessage.value = R.string.category_error
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }
}