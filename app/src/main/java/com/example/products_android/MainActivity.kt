package com.example.products_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.products_android.Networking.NetworkManager
import com.example.products_android.Networking.model.Products
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        NetworkManager.getService().getProducts()
            .enqueue(object :Callback<Products>{
                override fun onResponse(call: Call<Products>, response: Response<Products>) {
                    Log.e("response Code", response.code().toString())
                    Log.e("response", response.body().toString())
                    Log.e("error", response.errorBody().toString())
                }

                override fun onFailure(call: Call<Products>, t: Throwable) {
                    Log.e("error",t.localizedMessage)
                }

            })
    }
}