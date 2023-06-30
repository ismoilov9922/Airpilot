package uz.roboticslab.droneline

import android.content.Context
import android.content.ContextWrapper
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import uz.roboticslab.droneline.databinding.ActivityMainBinding
import uz.roboticslab.droneline.utils.ContextUtils
import uz.roboticslab.droneline.utils.Settings
import java.util.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun attachBaseContext(newBase: Context) {
        var localeToSwitchTo: Locale = if (Settings.getLang == "uz") {
            Locale("uz")
        } else if (Settings.getLang == "en") {
            Locale("en")
        } else {
            Locale("ru")
        }
        val localeUpdatedContext: ContextWrapper =
            ContextUtils.updateLocale(newBase, localeToSwitchTo)
        super.attachBaseContext(localeUpdatedContext)
    }
}