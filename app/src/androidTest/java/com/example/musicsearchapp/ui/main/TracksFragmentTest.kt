package com.example.musicsearchapp.ui.main

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.musicsearchapp.R
import com.google.common.truth.Truth.assertThat
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TracksFragmentTest : TestCase() {

    private lateinit var scenario: FragmentScenario<TracksFragment>

    @Before
    fun setup() {
        scenario = launchFragmentInContainer(themeResId = R.style.Theme_MusicSearchApp)
        scenario.moveToState(Lifecycle.State.STARTED)
    }

    @Test
    fun testInputSearch() {
        val searchText = "Believe"
        onView(withId(R.id.edt_search)).perform(typeText(searchText))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.btn_search)).perform(click())
        assertThat(onView(withId(R.id.progress_bar)).check(matches(isDisplayed())))
    }

}