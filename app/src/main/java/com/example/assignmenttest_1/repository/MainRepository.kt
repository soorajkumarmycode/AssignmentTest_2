package com.example.assignmenttest_1.repository

import com.example.assignmenttest_1.network.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllMyProducts() = retrofitService.getAllProducts()
}