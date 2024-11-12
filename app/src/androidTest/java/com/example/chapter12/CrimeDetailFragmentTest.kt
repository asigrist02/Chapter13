package com.example.chapter12

import androidx.fragment.app.testing.FragmentScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isChecked
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class CrimeDetailFragmentTest {

    @Test
    fun testCrimeDetailFragmentUIElements() {
        // Launch the fragment in isolation
        val scenario = FragmentScenario.launchInContainer(CrimeDetailFragment::class.java)

        scenario.onFragment { fragment ->
            // Access and set up the Crime data as needed for your assertions
            val crime = fragment.crime
            crime.title = "Sample Crime"
            crime.isSolved = true
        }

        // Verify that the EditText displays the correct crime title
        onView(withId(R.id.crime_title))
            .check(matches(withText("Sample Crime")))

        // Verify that the CheckBox is checked
        onView(withId(R.id.crime_solved))
            .check(matches(isChecked()))
    }
}