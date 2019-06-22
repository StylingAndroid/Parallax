package com.stylingandroid.parallax.ui.main

import android.util.SparseArray
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.stylingandroid.parallax.R
import java.util.WeakHashMap

class ParallaxPageTransformer : ViewPager2.PageTransformer {

    companion object {
        private const val FOREGROUND_FACTOR = 0.5f
    }

    private val cache = WeakHashMap<View, ViewMappings>()

    override fun transformPage(page: View, position: Float) {
        val offset = page.width * position
        page.getMappings().also { mappings ->
            mappings[R.id.image_background]?.translationX = -offset
            mappings[R.id.image_foreground]?.translationX = offset * FOREGROUND_FACTOR
        }
    }

    private fun View.getMappings(): ViewMappings =
        cache[this] ?: ViewMappings().apply {
            put(R.id.image_background, findViewById(R.id.image_background))
            put(R.id.image_middleground, findViewById(R.id.image_middleground))
            put(R.id.image_foreground, findViewById(R.id.image_foreground))
            cache[this@getMappings] = this
        }

    private class ViewMappings : SparseArray<View>()
}
