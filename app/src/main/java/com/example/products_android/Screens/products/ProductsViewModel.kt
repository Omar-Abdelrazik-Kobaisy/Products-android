package com.example.products_android.Screens.products

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.products_android.Networking.NetworkManager
import com.example.products_android.Networking.model.Products
import com.example.products_android.Networking.model.ProductsItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductsViewModel: ViewModel() {

    val productsLiveData = MutableLiveData<List<ProductsItem?>?>()
    fun fetchProducts(){
        NetworkManager
            .getService()
            .getProducts()
            .enqueue(object : Callback<Products>{
                override fun onResponse(call: Call<Products>, response: Response<Products>) {
                    if(response.isSuccessful){
                        productsLiveData.value = response.body()?.products
                        Log.e("response ----->",response.body().toString())
                    }else{
                        Log.e("fail to load ",response.message())
                    }
                }
                override fun onFailure(call: Call<Products>, t: Throwable) {
//                    Log.e("failure",t.localizedMessage?.toString() ?: "")
                }
            })
    }
}