package com.example.mytrip

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.RootMatchers.withDecorView
import android.support.test.espresso.matcher.ViewMatchers.*
import android.view.View
import org.hamcrest.CoreMatchers.not

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java, false, true)

    @Test
    fun whenActivityIsLaunched_shouldDisplayInitialState() {
        onView(withId(R.id.editDistance)).check(matches(isDisplayed()))
        onView(withId(R.id.editPrice)).check(matches(isDisplayed()))
        onView(withId(R.id.editAutonomy)).check(matches(isDisplayed()))
        onView(withId(R.id.textResult)).check(matches(isDisplayed()))
        onView(withId(R.id.buttonCalculate)).check(matches(isDisplayed()))
    }

    @Test
    fun whenHandleCalculateIsCalledResult() {

        onView(withId(R.id.editDistance)).perform(typeText("30"), closeSoftKeyboard())
        onView(withId(R.id.editPrice)).perform(typeText("100"), closeSoftKeyboard())
        onView(withId(R.id.editAutonomy)).perform(typeText("15"), closeSoftKeyboard())

        onView(withId(R.id.buttonCalculate)).perform(click())

        onView(withId(R.id.textResult)).check(matches(not<View>(withText(""))))
        onView(withId(R.id.textResult)).check(matches(withText("Total: R$ 200.0")))

    }

    @Test
    fun whenNoText() {

        onView(withId(R.id.editDistance)).perform(typeText(""), closeSoftKeyboard())
        onView(withId(R.id.editPrice)).perform(typeText(""), closeSoftKeyboard())
        onView(withId(R.id.editAutonomy)).perform(typeText(""), closeSoftKeyboard())

        onView(withId(R.id.buttonCalculate)).perform(click())

        onView(withText("Por Favor Informe valores válidos"))
            .inRoot(withDecorView(not<View>(mActivityRule.activity.window.decorView)))
            .check(matches(isDisplayed()))

    }

    @Test
    fun whenHandleCalculateEditDistanceNoText() {

        onView(withId(R.id.editDistance)).perform(typeText(""), closeSoftKeyboard())
        onView(withId(R.id.editPrice)).perform(typeText("100"), closeSoftKeyboard())
        onView(withId(R.id.editAutonomy)).perform(typeText("15"), closeSoftKeyboard())

        onView(withId(R.id.buttonCalculate)).perform(click())

        onView(withText("Por Favor Informe valores válidos"))
            .inRoot(withDecorView(not<View>(mActivityRule.activity.window.decorView)))
            .check(matches(isDisplayed()))

    }

    @Test
    fun whenHandleCalculateEditPriceNoText() {

        onView(withId(R.id.editDistance)).perform(typeText("30"), closeSoftKeyboard())
        onView(withId(R.id.editPrice)).perform(typeText(""), closeSoftKeyboard())
        onView(withId(R.id.editAutonomy)).perform(typeText("15"), closeSoftKeyboard())

        onView(withId(R.id.buttonCalculate)).perform(click())

        onView(withText("Por Favor Informe valores válidos"))
            .inRoot(withDecorView(not<View>(mActivityRule.activity.window.decorView)))
            .check(matches(isDisplayed()))

    }

    @Test
    fun whenHandleCalculateEditAutonomyNoText() {

        onView(withId(R.id.editDistance)).perform(typeText("30"), closeSoftKeyboard())
        onView(withId(R.id.editPrice)).perform(typeText("100"), closeSoftKeyboard())
        onView(withId(R.id.editAutonomy)).perform(typeText(""), closeSoftKeyboard())

        onView(withId(R.id.buttonCalculate)).perform(click())

        onView(withText("Por Favor Informe valores válidos"))
            .inRoot(withDecorView(not<View>(mActivityRule.activity.window.decorView)))
            .check(matches(isDisplayed()))

    }

    @Test
    fun whenHandleCalculateEditDistanceWrongNumber() {

        onView(withId(R.id.editDistance)).perform(typeText("asdsaasdds"), closeSoftKeyboard())
        onView(withId(R.id.editPrice)).perform(typeText("100"), closeSoftKeyboard())
        onView(withId(R.id.editAutonomy)).perform(typeText("15"), closeSoftKeyboard())

        onView(withId(R.id.buttonCalculate)).perform(click())

        onView(withText("Por Favor Informe valores válidos"))
            .inRoot(withDecorView(not<View>(mActivityRule.activity.window.decorView)))
            .check(matches(isDisplayed()))

    }

    @Test
    fun whenHandleCalculateEditPriceWrongNumber() {

        onView(withId(R.id.editDistance)).perform(typeText("30"), closeSoftKeyboard())
        onView(withId(R.id.editPrice)).perform(typeText("asdsaasdds"), closeSoftKeyboard())
        onView(withId(R.id.editAutonomy)).perform(typeText("15"), closeSoftKeyboard())

        onView(withId(R.id.buttonCalculate)).perform(click())

        onView(withText("Por Favor Informe valores válidos"))
            .inRoot(withDecorView(not<View>(mActivityRule.activity.window.decorView)))
            .check(matches(isDisplayed()))

    }

    @Test
    fun whenHandleCalculateEditAutonomyWrongNumber() {

        onView(withId(R.id.editDistance)).perform(typeText("30"), closeSoftKeyboard())
        onView(withId(R.id.editPrice)).perform(typeText("100"), closeSoftKeyboard())
        onView(withId(R.id.editAutonomy)).perform(typeText("asdsaasdds"), closeSoftKeyboard())

        onView(withId(R.id.buttonCalculate)).perform(click())

        onView(withText("Por Favor Informe valores válidos"))
            .inRoot(withDecorView(not<View>(mActivityRule.activity.window.decorView)))
            .check(matches(isDisplayed()))

    }

}
