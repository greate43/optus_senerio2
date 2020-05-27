package com.greate43.sk.optussenerio2.view.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.greate43.sk.optussenerio2.R
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    var activityRule: ActivityTestRule<MainActivity>
            = ActivityTestRule(MainActivity::class.java)


    @Before
    fun init(){
        activityRule.activity
            .supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainerView, MainFragment.newInstance()).commit()
    }
    @Test
    fun text_CheckIfFragmentDisplayed() {
        onView(withId(R.id.fragmentContainerView)).check(matches(isDisplayed()))
    }
}