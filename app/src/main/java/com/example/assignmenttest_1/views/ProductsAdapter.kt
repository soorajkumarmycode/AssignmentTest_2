package com.example.assignmenttest_1.views

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assignmenttest_1.databinding.ProductsItemRowLayoutBinding
import com.example.assignmenttest_1.model.Product

class ProductsAdapter : RecyclerView.Adapter<MainViewHolder>() {
    var products = mutableListOf<Product>()

    fun setProductList(products: List<Product>){

        this.products = products.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ProductsItemRowLayoutBinding.inflate(inflater,parent,false)
        return MainViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        val product = products[position]
        holder.binding.titleTextView.text = product.title
        holder.binding.descriptionTextView.text = product.description
        holder.binding.priceTextView3.text = product.price.toString()
        holder.binding.discountpriceTextView.text = product.discountPercentage.toString()
        Glide.with(holder.itemView.context)
            .load(product.images)
            .error(product.thumbnail)
            .into(holder.binding.productImageView)



    }
    override fun getItemCount(): Int {
        return products.size
    }


}
class MainViewHolder(val binding:ProductsItemRowLayoutBinding):RecyclerView.ViewHolder(binding.root)

