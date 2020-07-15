package com.prasetyanurangga.moview.ui.view

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.contrib.ViewPagerActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.prasetyanurangga.moview.R
import com.prasetyanurangga.moview.data.local.MoviewData
import org.junit.Test
import org.junit.Rule

class MainActivityTest {

    var dummyMovie = MoviewData.getDataMovie()
    var dummyTvShow = MoviewData.getDataTvShow()

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity>
            = ActivityTestRule(MainActivity::class.java)

    @Test
    fun loadMovies(){
        onView(withId(R.id.list_event_mo))
            .check(matches(isDisplayed()))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun detailMovie(){
        onView(withId(R.id.list_event_mo))
            .check(matches(isDisplayed()))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.txt_title_moview))
            .check(matches(isDisplayed()))
            .check(matches(withText(dummyMovie[0].title)))

        onView(withId(R.id.txt_adult_moview))
            .check(matches(isDisplayed()))
            .check(matches(withText(if(dummyMovie[0].isAdult)  "Yes" else "No" )))

        onView(withId(R.id.txt_date_moview))
            .check(matches(isDisplayed()))
            .check(matches(withText(dummyMovie[0].releaseDate)))

        onView(withId(R.id.txt_language_moview))
            .check(matches(isDisplayed()))
            .check(matches(withText(dummyMovie[0].originalLanguage)))

        onView(withId(R.id.txt_overview_moview))
            .check(matches(isDisplayed()))
            .check(matches(withText(dummyMovie[0].overview)))

        onView(withId(R.id.txt_vote_a_moview))
            .check(matches(isDisplayed()))
            .check(matches(withText(dummyMovie[0].voteAverage)))

        onView(withId(R.id.txt_vote_c_moview))
            .check(matches(isDisplayed()))
            .check(matches(withText(dummyMovie[0].voteCount)))

        onView(withId(R.id.img_moview))
            .check(matches(isDisplayed()))
    }



    @Test
    fun swipePage() {
        onView(withId(R.id.view_pager))
            .check(matches(isDisplayed()))
        onView(withId(R.id.view_pager))
            .perform(ViewPagerActions.scrollRight())
    }

    @Test
    fun loadTvShows(){
        onView(withId(R.id.view_pager))
            .perform(ViewPagerActions.scrollRight())

        onView(withId(R.id.list_event_tv))
            .check(matches(isDisplayed()))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
    }

    @Test
    fun detailTvShow(){
        onView(withId(R.id.view_pager))
            .check(matches(isDisplayed()))
            .perform(ViewPagerActions.scrollRight())
        
        onView(withId(R.id.list_event_tv))
            .check(matches(isDisplayed()))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.txt_title_moview))
            .check(matches(isDisplayed()))
            .check(matches(withText(dummyTvShow[0].title)))

        onView(withId(R.id.txt_adult_moview))
            .check(matches(isDisplayed()))
            .check(matches(withText(if(dummyTvShow[0].isAdult)  "Yes" else "No" )))

        onView(withId(R.id.txt_date_moview))
            .check(matches(isDisplayed()))
            .check(matches(withText(dummyTvShow[0].firstAirDate)))

        onView(withId(R.id.txt_language_moview))
            .check(matches(isDisplayed()))
            .check(matches(withText(dummyTvShow[0].originalLanguage)))

        onView(withId(R.id.txt_overview_moview))
            .check(matches(isDisplayed()))
            .check(matches(withText(dummyTvShow[0].overview)))

        onView(withId(R.id.txt_vote_a_moview))
            .check(matches(isDisplayed()))
            .check(matches(withText(dummyTvShow[0].voteAverage)))

        onView(withId(R.id.txt_vote_c_moview))
            .check(matches(isDisplayed()))
            .check(matches(withText(dummyTvShow[0].voteCount)))

        onView(withId(R.id.img_moview))
            .check(matches(isDisplayed()))
    }
}