package com.basim.mercari.pages

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import com.basim.mercari.R
import com.basim.mercari.utils.RecyclerViewMatcher
import org.hamcrest.Matchers.allOf


class HomePage {

    /**
     * This function is used to verify if home page is loaded properly
     **/
    fun verifyHomePageOpened(){
        onView(ViewMatchers.withId(R.id.view_pager))
            .check(
                ViewAssertions.matches(
                ViewMatchers.withEffectiveVisibility(
                    ViewMatchers.Visibility.VISIBLE)))
    }

    /**
     * This function is used to verify FAB
     **/
    fun verifyFabButton(){
        onView(ViewMatchers.withId(R.id.fab))
            .check(
                ViewAssertions.matches(
                    ViewMatchers.withEffectiveVisibility(
                        ViewMatchers.Visibility.VISIBLE)))
    }

    /**
     * This function is used to verify FAB tap
     **/
    fun tapAndVerifyFAB(){
        onView(ViewMatchers.withId(R.id.fab)).perform(click())
        onView(allOf(withId(android.support.design.R.id.snackbar_text), withText(R.string.fab_click)))
            .check(matches(isDisplayed()))
    }

    /**
     * This function is used to verify category title
     **/
    fun verifyCategoryTitle(categoryName:String){
        onView(allOf(withText(categoryName), isDescendantOfA(withId(R.id.tabs))))
            .perform(click())
            .check(matches(isDisplayed()))
    }

    /**
     * This function is used to verify products recycler view
     * @param productName product name to verify in list
     * @param likeNumber like number to verify in list
     * @param commentNumber comment number to verify in list
     * @param price price to verify in list
     **/
    fun verifyProductsData(productName:String, likeNumber:String, commentNumber:String, price:String){
        onView(RecyclerViewMatcher(R.id.product_list)
                .atPositionOnView(0, R.id.productNameTextView))
            .check(matches(withText(productName)))
        onView(RecyclerViewMatcher(R.id.product_list)
                .atPositionOnView(0, R.id.likeTextView))
            .check(matches(withText(likeNumber)))
        onView(RecyclerViewMatcher(R.id.product_list)
                .atPositionOnView(0, R.id.commentTextView))
            .check(matches(withText(commentNumber)))
        onView(RecyclerViewMatcher(R.id.product_list)
                .atPositionOnView(0, R.id.pricetextView))
            .check(matches(withText(price)))
    }

}