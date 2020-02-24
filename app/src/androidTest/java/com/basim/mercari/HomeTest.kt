package com.basim.mercari

import androidx.test.espresso.IdlingRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.basim.mercari.base.BaseTest
import com.basim.mercari.pages.HomePage
import com.basim.mercari.utils.idlingresource.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 * This class consists of all test cases related to home page
 */
@RunWith(AndroidJUnit4::class)
class HomeTest:BaseTest() {

    private val homePage:HomePage = HomePage()
    private val idlingResource = EspressoIdlingResource.getIdlingResource()

    /**
     * This method will be executed before each test. We will register idling resource here
     */
    @Before
    fun beforeTest() {
        IdlingRegistry.getInstance().register(idlingResource)
    }

    /**
     * This testcase will verify FAB and its click
     * Test ID:01
     * Author:Basim Sherif
     * **/
    @Test
    fun testFAB() {
        homePage.verifyHomePageOpened()
        homePage.verifyFabButton()
        homePage.tapAndVerifyFAB()
    }

    /**
     * This testcase will verify categories view pager titles
     * Test ID:02
     * Author:Basim Sherif
     * **/
    @Test
    fun testCategory() {
        homePage.verifyCategoryTitle("MEN")
        homePage.verifyCategoryTitle("WOMEN")
        homePage.verifyCategoryTitle("ALL")
    }

    /**
     * This testcase will verify products recycler view
     * Test ID:03
     * Author:Basim Sherif
     * **/
    @Test
    fun testProduct() {
        homePage.verifyProductsData("men1", "91", "59","$51.0")
    }

    /**
     * This method will be executed after each test. We will un-register idling resource here
     */
    @After
    fun unregisterIdlingResource() {
        if (idlingResource != null) {
            IdlingRegistry.getInstance().unregister(idlingResource)
        }
    }
}
