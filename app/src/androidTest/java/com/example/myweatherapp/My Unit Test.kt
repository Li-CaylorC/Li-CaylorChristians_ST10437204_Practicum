package com.example.myweatherapp

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Test
    fun testNextButton() {
        val intent = Intent(
            InstrumentationRegistry.getInstrumentation().targetContext,
            MainActivity::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        val activity = InstrumentationRegistry.getInstrumentation().startActivitySync(intent)

        // Click on the Next button
        onView(withId(R.id.nextBtn)).perform(click())

        // Check if MainActivity2 is launched
        onView(withId(R.id.etInsertDay)).check(matches(isDisplayed()))

        // Finish MainActivity
        activity.finish()
    }

    @Test
    fun testExitButton() {
        val intent = Intent(
            InstrumentationRegistry.getInstrumentation().targetContext,
            MainActivity::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        val activity = InstrumentationRegistry.getInstrumentation().startActivitySync(intent)

        // Click on the Exit button
        onView(withId(R.id.exitBtn)).perform(click())

        // Check if MainActivity is finished
        assert(activity.isFinishing)
    }
}

@RunWith(AndroidJUnit4::class)
class MainActivity2Test {

    @Test
    fun testSaveData() {
        val intent = Intent(
            InstrumentationRegistry.getInstrumentation().targetContext,
            MainActivity2::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        val activity = InstrumentationRegistry.getInstrumentation().startActivitySync(intent)

        // Type data into the EditText fields
        onView(withId(R.id.etInsertDay)).perform(typeText("Monday"))
        onView(withId(R.id.etMin)).perform(typeText("20"))
        onView(withId(R.id.etMax)).perform(typeText("30"))
        onView(withId(R.id.etWeatherCon)).perform(typeText("Sunny"))

        // Click on the add data button
        onView(withId(R.id.addDatabtn)).perform(click())

        // Check if the data is saved successfully
        onView(withText("Data saved successfully")).inRoot(ToastMatcher())
            .check(matches(isDisplayed()))

        // Finish MainActivity2
        activity.finish()
    }

    @Test
    fun testViewSummaryData() {
        val intent = Intent(
            InstrumentationRegistry.getInstrumentation().targetContext,
            MainActivity2::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        InstrumentationRegistry.getInstrumentation().startActivitySync(intent)

        // Click on the view summary button
        onView(withId(R.id.viewSumBtn)).perform(click())

        // Check if MainActivity3 is launched
        onView(withId(R.id.activity_main3)).check(matches(isDisplayed()))
    }
}

@RunWith(AndroidJUnit4::class)
class MainActivity3Test {

    @Test
    fun testSummaryDataDisplayed() {
        val intent = Intent(
            InstrumentationRegistry.getInstrumentation().targetContext,
            MainActivity3::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        val activity = InstrumentationRegistry.getInstrumentation().startActivitySync(intent)

        // Check if the summary data is displayed correctly
        onView(withId(R.id.tvResults)).check(matches(isDisplayed()))

        // Finish MainActivity3
        activity.finish()
    }
}
