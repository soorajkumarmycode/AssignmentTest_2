package com.example.assignmenttest_1.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignmenttest_1.R
import com.example.assignmenttest_1.databinding.ActivityMainBinding
import com.example.assignmenttest_1.network.RetrofitService
import com.example.assignmenttest_1.repository.MainRepository
import com.example.assignmenttest_1.viewModel.MainViewModel
import com.example.assignmenttest_1.viewModel.MyViewModelFactory

class MainActivity : AppCompatActivity() {


    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    private val retrofitService = RetrofitService.getInstance()
    private val adapter = ProductsAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService)))[MainViewModel::class.java]
        binding.recycleview.layoutManager = LinearLayoutManager(this)
        viewModel.productsList.observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            binding.recycleview.adapter = adapter
            adapter.setProductList(it.products)
            adapter.notifyDataSetChanged()
        })
        viewModel.errorMsg.observe(this, Observer {
        })
        viewModel.getAllProducts()

    }
}