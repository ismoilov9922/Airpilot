package uz.roboticslab.droneline.ui.setting

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import uz.roboticslab.droneline.R
import uz.roboticslab.droneline.databinding.FragmentSettingBinding
import uz.roboticslab.droneline.utils.CashStorage
import uz.roboticslab.droneline.utils.Settings

class SettingFragment : Fragment() {
    private lateinit var binding: FragmentSettingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingBinding.inflate(layoutInflater)
        binding.switchBtn.isChecked = Settings.isNightMode
        binding.switchBtn.setOnCheckedChangeListener { p0, p1 ->
            if (p1) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                CashStorage.addTheme(requireContext(), true)
                Settings.isNightMode = true
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                CashStorage.addTheme(requireContext(), false)
                Settings.isNightMode = false
            }
        }
        binding.share.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            val imageUri =
                "https://play.google.com/store/apps/details?id=com.Asteroid.droneremotecontrol"
            intent.putExtra(Intent.EXTRA_SUBJECT, "Drone Line")
            intent.putExtra(Intent.EXTRA_TEXT, imageUri)
            startActivity(Intent.createChooser(intent, imageUri))
        }
        binding.infoApp.setOnClickListener {
            val alertDialog = context?.let { AlertDialog.Builder(it) }
            val dialog = alertDialog!!.create()
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            val dialogView: View = layoutInflater.inflate(
                R.layout.app_info_dialog,
                null,
                false
            )
            dialog.setView(dialogView)
            dialog.show()
        }
        return binding.root
    }
}