package com.github.tatsuyafujisaki.rtlsplsample

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import androidx.annotation.ColorInt
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.slidingpanelayout.widget.SlidingPaneLayout
import com.github.tatsuyafujisaki.rtlsplsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setSupportActionBar(binding.toolbar)
        binding.slidingPane.sliderFadeColor = getColor(R.color.overlayShadow)

        binding.slidingPane.setPanelSlideListener(
            object : SlidingPaneLayout.PanelSlideListener {
                override fun onPanelSlide(panel: View, slideOffset: Float) {
                }

                override fun onPanelOpened(panel: View) {
                }

                override fun onPanelClosed(panel: View) {
                    binding.openOverlayButton.isVisible = true
                }
            })

        setContentView(binding.root)
    }

    fun onClickButton(view: View) {
        view.isInvisible = true
        binding.slidingPane.open()
    }

    fun setText(s: String) {
        binding.timestampTextView.text = s
    }

    var backgroundColor: Int?
        get() = (binding.backgroundConstraintLayout.background as? ColorDrawable)?.color
        set(@ColorInt color) {
            color?.let {
                binding.backgroundConstraintLayout.setBackgroundColor(it)
            }
        }
}
