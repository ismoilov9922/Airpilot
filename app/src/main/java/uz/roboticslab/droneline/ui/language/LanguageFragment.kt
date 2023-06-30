package uz.roboticslab.droneline.ui.language

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.roboticslab.droneline.databinding.FragmentLanguageBinding
import uz.roboticslab.droneline.utils.CashStorage
import uz.roboticslab.droneline.utils.Settings

class LanguageFragment : Fragment() {
    private lateinit var binding: FragmentLanguageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLanguageBinding.inflate(layoutInflater)
        if (CashStorage.getLang(requireContext()) == "uz") {
            binding.uz.isChecked = true
        }
        if (CashStorage.getLang(requireContext()) == "ru") {
            binding.ru.isChecked = true
        }
        if (CashStorage.getLang(requireContext()) == "en") {
            binding.eng.isChecked = true
        }
        binding.btnLang.setOnClickListener {
            if (binding.uz.isChecked) {
                CashStorage.addLanguage(requireContext(), "uz")
                Settings.getLang = "uz"
                requireActivity().recreate()
            }
            if (binding.eng.isChecked) {
                CashStorage.addLanguage(requireContext(), "en")
                Settings.getLang = "en"
                requireActivity().recreate()
            }
            if (binding.ru.isChecked) {
                CashStorage.addLanguage(requireContext(), "ru")
                Settings.getLang = "ru"
                requireActivity().recreate()
            }
            findNavController().popBackStack()
        }
        binding.backHome.setOnClickListener {
            findNavController().popBackStack()
        }

        return binding.root
    }
}