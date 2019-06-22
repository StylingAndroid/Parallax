package com.stylingandroid.parallax.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.stylingandroid.parallax.R

class SectionsPagerAdapter(
    private val activity: FragmentActivity
) : FragmentStateAdapter(activity) {

    override fun createFragment(position: Int): Fragment =
        ParallaxFragment()

    fun getPageTitle(position: Int): CharSequence =
        activity.resources.getString(TAB_TITLES[position])

    override fun getItemCount(): Int = TAB_TITLES.size

    companion object {
        private val TAB_TITLES = arrayOf(
            R.string.tab_text_1,
            R.string.tab_text_2
        )
    }
}
