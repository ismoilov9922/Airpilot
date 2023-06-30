package uz.roboticslab.droneline.ui.fly_drone

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import uz.roboticslab.droneline.R
import uz.roboticslab.droneline.databinding.FragmentWifiBinding

class WifiFragment : Fragment() {
    private lateinit var binding: FragmentWifiBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWifiBinding.inflate(layoutInflater)
        binding.cameraBtn1.setOnClickListener {

        }
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        activity?.window?.statusBarColor =
            ContextCompat.getColor(requireContext(), R.color.app_color)
    }
}