package uz.roboticslab.droneline.ui.learn_fly.aviamodel

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
import uz.roboticslab.droneline.databinding.FragmentAviaModelBinding

@AndroidEntryPoint
class AviaModelFragment : Fragment() {
    private lateinit var binding: FragmentAviaModelBinding
    private lateinit var adapter: VideoAdapter
    private lateinit var list: List<VideoHome>
    private var typeId: Int = 1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAviaModelBinding.inflate(layoutInflater)
        typeId = arguments?.getInt("id") as Int
        when (typeId) {
            1 -> {
                list = LoadList.getAviaModel()
                binding.title.text = "Avia Model"
            }
            2 -> {
                list = LoadList.getRaketaModel()
                binding.title.text = "Raketa Model"
            }
            3 -> {
                list = LoadList.getList()
                binding.title.text = "Harbiy dronlar"
            }
        }
        adapter =
            VideoAdapter(list, object : VideoAdapter.OnItemClickListener {
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