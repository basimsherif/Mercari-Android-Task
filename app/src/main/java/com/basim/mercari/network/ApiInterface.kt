package com.basim.mercari.data.model

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * An Interface to communicate with API using Retrofit
 * */
interface ApiInterface {
    /**
     * Get the list of the pots from the API
     */
    @GET("master.json")
    fun getCategories(): Observable<List<Category>>

    /**
     * Get the list of the products from the API
     */
    @GET("{category}")
    fun getProducts(@Path("category")category: String): Observable<List<Product>>
}