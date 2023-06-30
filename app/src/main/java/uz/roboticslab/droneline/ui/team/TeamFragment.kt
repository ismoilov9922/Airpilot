package uz.roboticslab.droneline.ui.team

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.roboticslab.droneline.databinding.FragmentTeamBinding

class TeamFragment : Fragment() {
    private lateinit var binding: FragmentTeamBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTeamBinding.inflate(layoutInflater)
        binding.backHome.setOnClickListener {
            findNavController().popBackStack()
        }
        return binding.root
    }
}