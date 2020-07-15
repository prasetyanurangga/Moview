package com.prasetyanurangga.moview.ui.view

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import com.prasetyanurangga.footballleague.ui.adapter.ViewPagerAdapter
import com.prasetyanurangga.moview.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sectionsPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        sectionsPagerAdapter.populateFragment(MovieFragment(), "Movies", this)
        sectionsPagerAdapter.populateFragment(TvShowFragment(), "TV Shows", this)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)


    }

}