package com.basim.mercari.ui.main

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.basim.mercari.R
import com.basim.mercari.data.model.Category

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager, categoryList: List<Category>?) : FragmentPagerAdapter(fm) {

    private var categoryList:List<Category>? = categoryList

    override fun getItem(position: Int): Fragment {
        return CategoryFragment.newInstance(categoryList!!.get(position))
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return categoryList?.get(position)!!.name
    }


    override fun getCount(): Int {
        return categoryList!!.size
    }


}