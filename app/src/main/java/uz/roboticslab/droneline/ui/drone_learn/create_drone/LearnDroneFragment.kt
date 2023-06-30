package uz.roboticslab.droneline.ui.drone_learn.create_drone

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import uz.roboticslab.droneline.adapter.VideoAdapter
import uz.roboticslab.droneline.models.VideoHome
import uz.roboticslab.droneline.ui.youtube_video.VideoActivity
import com.example.droneline.utils.LoadList
import dagger.hilt.android.AndroidEntryPoint
import uz.roboticslab.droneline.R
import uz.roboticslab.droneline.databinding.FragmentLearnDronBinding

@AndroidEntryPoint
class LearnDroneFragment : Fragment() {
    private lateinit var binding: FragmentLearnDronBinding
    private lateinit var adapter: VideoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLearnDronBinding.inflate(layoutInflater)
        adapter =
            VideoAdapter(LoadList.getLearnDroneVideo(), object : VideoAdapter.OnItemClickListener {
                override fun onItemClick(item: VideoHome) {
                    val intent = Intent(requireContext(), VideoActivity::class.java)
                    intent.putExtra("videoId", item.videoId)
                    startActivity(intent)
                }
            })
        binding.rv.adapter = adapter
        binding.backHome.setOnClickListener {
            findNavController().popBackStack()
        }
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        activity?.window?.statusBarColor =
            ContextCompat.getColor(requireContext(), R.color.blue)
    }
}