package uz.roboticslab.droneline.ui.drone_learn.instrument

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.OvershootInterpolator
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.roboticslab.droneline.adapter.InstAdapter
import uz.roboticslab.droneline.models.InstData
import com.example.droneline.utils.LoadList
import uz.roboticslab.droneline.utils.errorToast
import dagger.hilt.android.AndroidEntryPoint
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter
import uz.roboticslab.droneline.R
import uz.roboticslab.droneline.databinding.FragmentInstrDroneBinding

@AndroidEntryPoint
class InstrDroneFragment : Fragment() {
    private lateinit var binding: FragmentInstrDroneBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInstrDroneBinding.inflate(layoutInflater)

        init()
        setUi()
        return binding.root
    }

    private fun init() {
        val scaleAdapter = ScaleInAnimationAdapter(
            InstAdapter(
                LoadList.getInstrumentList(),
                object : InstAdapter.OnItemCLick {
                    override fun onClick(instData: InstData) {
                        try {
                            val myIntent = Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://es.aliexpress.com/item/1005003052480251.html?spm=a2g0o.productlist.0.0.6d793479kLLR2y&algo_pvid=69cf4404-8fd2-4153-bc1e-9a10215e5441&algo_exp_id=69cf4404-8fd2-4153-bc1e-9a10215e5441-0&pdp_ext_f=%7B%22sku_id%22%3A%2212000023517859883%22%7D&pdp_pi=-1%3B39.67%3B-1%3B-1%40salePrice%3BEUR%3Bsearch-mainSearch")
                            )
                            startActivity(myIntent)
                        } catch (e: ActivityNotFoundException) {
                            errorToast(requireContext(), "Invalit link!!")
                            e.printStackTrace()
                        }
                    }
                })
        )
        scaleAdapter.setInterpolator(OvershootInterpolator())
        scaleAdapter.setFirstOnly(false)
        scaleAdapter.setDuration(500)
        binding.rv.adapter = scaleAdapter
    }

    private fun setUi() {
        binding.backHome.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onStart() {
        super.onStart()
        activity?.window?.statusBarColor =
            ContextCompat.getColor(requireContext(), R.color.blue)
    }
}