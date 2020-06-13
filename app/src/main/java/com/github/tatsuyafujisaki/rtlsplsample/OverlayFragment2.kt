package com.github.tatsuyafujisaki.rtlsplsample

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.tatsuyafujisaki.rtlsplsample.databinding.FragmentOverlay2Binding
import java.time.LocalTime

class OverlayFragment2 : Fragment() {
    private var _binding: FragmentOverlay2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOverlay2Binding.inflate(inflater, container, false)

        binding.changeBackgroundButton.setOnClickListener {
            val activity = requireActivity() as MainActivity

            activity.setText(LocalTime.now().toString())

            activity.backgroundColor = when(activity.backgroundColor) {
                Color.RED -> Color.GREEN
                Color.GREEN -> Color.BLUE
                else -> Color.RED
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
