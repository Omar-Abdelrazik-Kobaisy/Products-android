package com.example.products_android.Networking


import kotlinx.coroutines.internal.SynchronizedObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkManager {

    companion object{
        var retrofit: Retrofit? = null
        @Synchronized
        private fun getInstance(): Retrofit{
            if(retrofit == null){
                retrofit = Retrofit.Builder()
                    .baseUrl(BaseDomain.production.domain)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return  retrofit!!
        }
        fun getService(): ProductsService{
            return getInstance().create(ProductsService::class.java)
        }
    }
}