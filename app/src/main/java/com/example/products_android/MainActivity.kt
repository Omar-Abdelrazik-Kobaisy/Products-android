package com.example.products_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.products_android.Networking.NetworkManager
import com.example.products_android.Networking.model.Products
import com.example.products_android.Screens.products.ProductsViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    var viewModel: ProductsViewModel = ProductsViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.fetchProducts()
    }
}