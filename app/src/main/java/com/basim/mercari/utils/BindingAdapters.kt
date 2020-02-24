package com.basim.mercari.utils

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.databinding.BindingAdapter
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import com.basim.mercari.R
import com.basim.mercari.utils.extension.getParentActivity
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.Glide

@BindingAdapter("mutableVisibility")
fun setMutableVisibility(view: View, visibility: MutableLiveData<Int>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if(parentActivity != null && visibility != null) {
        visibility.observe(parentActivity, Observer { value -> view.visibility = value?:View.VISIBLE})
    }
}

@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

@BindingAdapter("mutableText")
fun setMutableText(view: TextView,  text: MutableLiveData<String>?) {
    val parentActivity:AppCompatActivity? = view.getParentActivity()
    if(parentActivity != null && text != null) {
        text.observe(parentActivity, Observer { value -> view.text = value?:""})
    }
}

@BindingAdapter("mutableImageURL")
fun setMutableImageURL(view: ImageView, imageUrl: MutableLiveData<String>?) {
    val parentActivity:AppCompatActivity? = view.getParentActivity()
    if(parentActivity != null && imageUrl != null) {
        imageUrl.observe(parentActivity, Observer { value -> Glide.with(view.context)
            .load(value.toString()).apply(RequestOptions().centerCrop())
            .into(view)})
    }
}

@BindingAdapter("mutableNumber")
fun setMutableNumber(view: TextView,  text: MutableLiveData<Int>?) {
    val parentActivity:AppCompatActivity? = view.getParentActivity()
    if(parentActivity != null && text != null) {
        text.observe(parentActivity, Observer { value -> view.text = value.toString() })
    }
}

@BindingAdapter("mutablePrice")
fun setMutablePrice(view: TextView,  text: MutableLiveData<Double>?) {
    val parentActivity:AppCompatActivity? = view.getParentActivity()
    if(parentActivity != null && text != null) {
        text.observe(parentActivity, Observer { value ->
            view.text = "$$value"
        })
    }
}

@BindingAdapter("mutableStatus")
fun setMutableStatus(view: ImageView, statusText: MutableLiveData<String>?) {
    val parentActivity:AppCompatActivity? = view.getParentActivity()
    if(parentActivity != null && statusText != null) {
        statusText.observe(parentActivity, Observer { value ->
           if(value.toString() == "sold_out")
               view.visibility = View.VISIBLE
            else
               view.visibility = View.GONE
        })
    }
}