package uz.roboticslab.droneline.ui.virtual.real

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.roboticslab.droneline.databinding.FragmentRealBinding

class RealFragment : Fragment() {
    private lateinit var binding: FragmentRealBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRealBinding.inflate(layoutInflater)

        return binding.root
    }
}