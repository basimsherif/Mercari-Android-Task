package com.basim.mercari.ui.product

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.basim.mercari.R
import com.basim.mercari.data.model.Product
import com.basim.mercari.databinding.ItemProductBinding


class ProductListAdapter: RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {
    private lateinit var productList:List<Product>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListAdapter.ViewHolder {
        val binding: ItemProductBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_product, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductListAdapter.ViewHolder, position: Int) {
        holder.bind(productList[position])
    }

    override fun getItemCount(): Int {
        return if(::productList.isInitialized) productList.size else 0
    }

    fun updateProductList(productList:List<Product>){
        this.productList = productList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemProductBinding):RecyclerView.ViewHolder(binding.root){
        private val viewModel = ProductViewModel()
        fun bind(product: Product){
            viewModel.bind(product)
            binding.viewModel = viewModel
        }
    }
}