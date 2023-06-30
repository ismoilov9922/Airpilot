package uz.roboticslab.droneline.ui.virtual.virtuals

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.roboticslab.droneline.databinding.FragmentVirtualBinding

class VirtualFragment : Fragment() {
    private lateinit var binding: FragmentVirtualBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVirtualBinding.inflate(layoutInflater)


        return binding.root
    }
}