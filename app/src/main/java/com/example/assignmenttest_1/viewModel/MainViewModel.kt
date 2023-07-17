package com.example.assignmenttest_1.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assignmenttest_1.model.Product
import com.example.assignmenttest_1.model.Products
import com.example.assignmenttest_1.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository):ViewModel() {


    val productsList = MutableLiveData<Products>()
    val errorMsg = MutableLiveData<String>()


    fun getAllProducts() {
        val response = repository.getAllMyProducts()
        response.enqueue(object : Callback<Products> {
            override fun onResponse(call: Call<Products>, response: Response<Products>) {
                productsList.postValue(response.body())
            }
            override fun onFailure(call: Call<Products>, t: Throwable) {
                errorMsg.postValue(t.message)
            }

        })
    }
}
