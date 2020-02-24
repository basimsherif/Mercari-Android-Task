package com.basim.mercari.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.basim.mercari.R
import com.basim.mercari.data.model.Category
import com.basim.mercari.databinding.FragmentMainBinding
import com.basim.mercari.ui.product.ProductListViewModel
import com.basim.mercari.ui.product.ProductViewModelFactory

/**
 * A Fragment for holding category list
 */
class CategoryFragment : Fragment() {

    private lateinit var productListViewModel: ProductListViewModel
    private var errorSnackbar: Snackbar? = null
    private lateinit var binding : FragmentMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater!!,R.layout.fragment_main,container , false)
        var myView : View  = binding.root
        binding.productList.layoutManager = GridLayoutManager(activity, 2)
        var categoryName: String = arguments?.getString(ARG_CATEGORY_NAME)!!.toLowerCase()
        productListViewModel = ViewModelProviders.of(this,ProductViewModelFactory(activity!!.applicationContext, "$categoryName.json")).get(ProductListViewModel::class.java)
        binding.viewModel = productListViewModel
        productListViewModel.errorMessage.observe(this, Observer {
                errorMessage -> if(errorMessage != null) showError(errorMessage) else hideError()
        })
        return myView
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_CATEGORY_NAME = "category_name"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(mCategory: Category): CategoryFragment {
            return CategoryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_CATEGORY_NAME, mCategory.name)
                }
            }
        }
    }

    private fun showError(@StringRes errorMessage:Int){
        errorSnackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.setAction(R.string.retry, productListViewModel.errorClickListener)
        errorSnackbar?.show()
    }

    private fun hideError(){
        errorSnackbar?.dismiss()
    }
}