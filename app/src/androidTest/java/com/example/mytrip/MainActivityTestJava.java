package com.example.mytrip;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.CoreMatchers.not;

@RunWith(AndroidJUnit4.class)

public class MainActivityTestJava {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class, false, true);

    @Test
    public void whenActivityIsLaunched_shouldDisplayInitialState() {
        onView(withId(R.id.editDistance)).check(matches(isDisplayed()));
        onView(withId(R.id.editPrice)).check(matches(isDisplayed()));
        onView(withId(R.id.editAutonomy)).check(matches(isDisplayed()));
        onView(withId(R.id.textResult)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonCalculate)).check(matches(isDisplayed()));
    }

    @Test
    public void whenHandleCalculateIsCalledResult() {

        onView(withId(R.id.editDistance)).perform(typeText("30"), closeSoftKeyboard());
        onView(withId(R.id.editPrice)).perform(typeText("100"), closeSoftKeyboard());
        onView(withId(R.id.editAutonomy)).perform(typeText("15"), closeSoftKeyboard());

        onView(withId(R.id.buttonCalculate)).perform(click());

        onView(withId(R.id.textResult)).check(matches(not(withText(""))));
        onView(withId(R.id.textResult)).check(matches((withText("Total: R$ 200.0"))));

    }

    @Test
    public void whenNoText() {

        onView(withId(R.id.editDistance)).perform(typeText(""), closeSoftKeyboard());
        onView(withId(R.id.editPrice)).perform(typeText(""), closeSoftKeyboard());
        onView(withId(R.id.editAutonomy)).perform(typeText(""), closeSoftKeyboard());

        onView(withId(R.id.buttonCalculate)).perform(click());

        onView(withText("Por Favor Informe valores válidos"))
                .inRoot(withDecorView(not(mActivityRule.getActivity().getWindow().getDecorView())))
                .check(matches(isDisplayed()));

    }

    @Test
    public void whenHandleCalculateEditDistanceNoText() {

        onView(withId(R.id.editDistance)).perform(typeText(""), closeSoftKeyboard());
        onView(withId(R.id.editPrice)).perform(typeText("100"), closeSoftKeyboard());
        onView(withId(R.id.editAutonomy)).perform(typeText("15"), closeSoftKeyboard());

        onView(withId(R.id.buttonCalculate)).perform(click());

        onView(withText("Por Favor Informe valores válidos"))
                .inRoot(withDecorView(not(mActivityRule.getActivity().getWindow().getDecorView())))
                .check(matches(isDisplayed()));

    }

    @Test
    public void whenHandleCalculateEditPriceNoText() {

        onView(withId(R.id.editDistance)).perform(typeText("30"), closeSoftKeyboard());
        onView(withId(R.id.editPrice)).perform(typeText(""), closeSoftKeyboard());
        onView(withId(R.id.editAutonomy)).perform(typeText("15"), closeSoftKeyboard());

        onView(withId(R.id.buttonCalculate)).perform(click());

        onView(withText("Por Favor Informe valores válidos"))
                .inRoot(withDecorView(not(mActivityRule.getActivity().getWindow().getDecorView())))
                .check(matches(isDisplayed()));

    }

    @Test
    public void whenHandleCalculateEditAutonomyNoText() {

        onView(withId(R.id.editDistance)).perform(typeText("30"), closeSoftKeyboard());
        onView(withId(R.id.editPrice)).perform(typeText("100"), closeSoftKeyboard());
        onView(withId(R.id.editAutonomy)).perform(typeText(""), closeSoftKeyboard());

        onView(withId(R.id.buttonCalculate)).perform(click());

        onView(withText("Por Favor Informe valores válidos"))
                .inRoot(withDecorView(not(mActivityRule.getActivity().getWindow().getDecorView())))
                .check(matches(isDisplayed()));

    }

    @Test
    public void whenHandleCalculateEditDistanceWrongNumber() {

        onView(withId(R.id.editDistance)).perform(typeText("asdsaasdds"), closeSoftKeyboard());
        onView(withId(R.id.editPrice)).perform(typeText("100"), closeSoftKeyboard());
        onView(withId(R.id.editAutonomy)).perform(typeText("15"), closeSoftKeyboard());

        onView(withId(R.id.buttonCalculate)).perform(click());

        onView(withText("Por Favor Informe valores válidos"))
                .inRoot(withDecorView(not(mActivityRule.getActivity().getWindow().getDecorView())))
                .check(matches(isDisplayed()));

    }

    @Test
    public void whenHandleCalculateEditPriceWrongNumber() {

        onView(withId(R.id.editDistance)).perform(typeText("30"), closeSoftKeyboard());
        onView(withId(R.id.editPrice)).perform(typeText("asdsaasdds"), closeSoftKeyboard());
        onView(withId(R.id.editAutonomy)).perform(typeText("15"), closeSoftKeyboard());

        onView(withId(R.id.buttonCalculate)).perform(click());

        onView(withText("Por Favor Informe valores válidos"))
                .inRoot(withDecorView(not(mActivityRule.getActivity().getWindow().getDecorView())))
                .check(matches(isDisplayed()));

    }

    @Test
    public void whenHandleCalculateEditAutonomyWrongNumber() {

        onView(withId(R.id.editDistance)).perform(typeText("30"), closeSoftKeyboard());
        onView(withId(R.id.editPrice)).perform(typeText("100"), closeSoftKeyboard());
        onView(withId(R.id.editAutonomy)).perform(typeText("asdsaasdds"), closeSoftKeyboard());

        onView(withId(R.id.buttonCalculate)).perform(click());

        onView(withText("Por Favor Informe valores válidos"))
                .inRoot(withDecorView(not(mActivityRule.getActivity().getWindow().getDecorView())))
                .check(matches(isDisplayed()));

    }

}
