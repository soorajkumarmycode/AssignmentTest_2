package com.example.assignmenttest_1.network

import com.example.assignmenttest_1.model.Product
import com.example.assignmenttest_1.model.Products
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface RetrofitService {

    @GET("products")
    fun getAllProducts():Call<Products>

    companion object{

        var retrofitService:RetrofitService?=null

        fun getInstance():RetrofitService{
            if (retrofitService==null){

                val retrofit = Retrofit.Builder()
                    .baseUrl("https://dummyjson.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                retrofitService= retrofit.create(RetrofitService::class.java)

            }
            return retrofitService!!
        }

    }
}