package uz.roboticslab.droneline.ui.home

import android.content.Intent
import android.content.pm.ActivityInfo
import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.OvershootInterpolator
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.roboticslab.droneline.adapter.AdapterOne
import uz.roboticslab.droneline.adapter.AdapterThree
import uz.roboticslab.droneline.adapter.AdapterTwo
import uz.roboticslab.droneline.ui.drone_learn.GameActivity
import com.example.droneline.utils.LoadList
import com.unity3d.player.UnityPlayerActivity
import uz.roboticslab.droneline.utils.Utils
import dagger.hilt.android.AndroidEntryPoint
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter
import uz.roboticslab.droneline.R
import uz.roboticslab.droneline.databinding.FragmentHomeBinding

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        binding.drawerMenu.setOnClickListener {
            binding.mainDrawerLayout.openDrawer(Gravity.LEFT)
        }
        val scaleAnimate = ScaleInAnimationAdapter(
            AdapterOne(
                LoadList.getListOne(),
                object : AdapterOne.OnItemClickListener {
                    override fun onItemClick(position: Int) {
                        when (position) {
                            1 -> {
                                val intent =
                                    Intent(requireContext(), UnityPlayerActivity::class.java)
                                startActivity(intent)
                            }
                            2 -> {
                                val intent = Intent(requireContext(), GameActivity::class.java)
                                intent.putExtra("type", 2)
                                startActivity(intent)
                            }
                            3 -> {
                                findNavController().navigate(R.id.wifiFragment)
                            }
                        }
                    }
                })
        )
        scaleAnimate.setInterpolator(OvershootInterpolator())
        scaleAnimate.setFirstOnly(false)
        scaleAnimate.setDuration(500)
        val scaleAnimation2 = ScaleInAnimationAdapter(
            AdapterTwo(
                LoadList.getListTwo(),
                object : AdapterTwo.OnItemCLick {
                    override fun onClickListener(id: Int) {
                        when (id) {
                            1 -> findNavController().navigate(R.id.instrDroneFragment)
                            2 -> findNavController().navigate(R.id.learnDroneFragment)
                            3 -> {
                                val myIntent = Intent(
                                    Intent.ACTION_VIEW,
                                    Uri.parse("https://www.drone-made.com/post/uzbekistan-drone-laws")
                                )
                                startActivity(myIntent)
                            }
                        }
                    }
                })
        )
        scaleAnimation2.setInterpolator(OvershootInterpolator())
        scaleAnimation2.setFirstOnly(false)
        scaleAnimation2.setDuration(500)
        val scaleAnimation3 = ScaleInAnimationAdapter(
            AdapterThree(
                LoadList.getListThree(),
                object : AdapterThree.OnClickListener {
                    override fun onClick(id: Int) {
                        val bundle = Bundle()
                        when (id) {
                            1 -> {
                                bundle.putInt("id", 1)
                                findNavController().navigate(R.id.aviaModelFragment, bundle)
                            }
                            2 -> {
                                bundle.putInt("id", 2)
                                findNavController().navigate(R.id.aviaModelFragment, bundle)
                            }
                            3 -> {
                                bundle.putInt("id", 3)
                                findNavController().navigate(R.id.aviaModelFragment, bundle)
                            }
                        }
                    }
                })
        )
        scaleAnimation3.setInterpolator(OvershootInterpolator())
        scaleAnimation3.setFirstOnly(false)
        scaleAnimation3.setDuration(500)
        binding.rv1.adapter = scaleAnimate
        binding.rv2.adapter = scaleAnimation2
        binding.rv3.adapter = scaleAnimation3
        binding.mainNavigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.setting -> {
                    findNavController().navigate(R.id.settingFragment)
                }
                R.id.language -> {
                    findNavController().navigate(R.id.languageFragment)
                }
                R.id.phone -> {
                    Utils().permissionCall(requireContext(), "+998953401070")
                }
                R.id.news -> {
                    findNavController().navigate(R.id.newsFragment)
                }
                R.id.drone_website -> {
                    findNavController().navigate(R.id.droneWebFragment)
                }
                R.id.drone_stores -> {
                    findNavController().navigate(R.id.droneStoresFragment)
                }
                R.id.about -> {
                    findNavController().navigate(R.id.teamFragment)
                }
            }
            binding.mainDrawerLayout.closeDrawer(GravityCompat.START)
            false
        }
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        activity?.window?.statusBarColor =
            ContextCompat.getColor(requireContext(), R.color.blue)
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }
}