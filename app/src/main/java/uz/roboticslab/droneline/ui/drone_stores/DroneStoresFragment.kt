package uz.roboticslab.droneline.ui.drone_stores

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.OvershootInterpolator
import androidx.navigation.fragment.findNavController
import uz.roboticslab.droneline.adapter.WebAdapter
import uz.roboticslab.droneline.models.DroneWeb
import com.example.droneline.utils.LoadList
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter
import uz.roboticslab.droneline.databinding.FragmentDroneStoresBinding

class DroneStoresFragment : Fragment() {
    private lateinit var binding: FragmentDroneStoresBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDroneStoresBinding.inflate(layoutInflater)
        val scaleAdapter = ScaleInAnimationAdapter(
            WebAdapter(
                LoadList.getDroneStories(),
                object : WebAdapter.OnItemCLick {
                    override fun onClick(droneWeb: DroneWeb) {
                        val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse(droneWeb.url))
                        startActivity(myIntent)
                    }
                })
        )
        scaleAdapter.setInterpolator(OvershootInterpolator())
        scaleAdapter.setFirstOnly(false)
        scaleAdapter.setDuration(500)
        binding.rv.adapter = scaleAdapter
        binding.backHome.setOnClickListener {
            findNavController().popBackStack()
        }

        return binding.root
    }
}