package com.example.products_android.Networking

import com.example.products_android.Networking.model.Products
import retrofit2.Call
import retrofit2.http.GET

interface ProductsService {
    @GET("/products")
    fun getProducts(): Call<Products>
}