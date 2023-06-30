package uz.roboticslab.droneline

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import uz.roboticslab.droneline.utils.Settings
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        if (getSharedPreferences(
                "Theme",
                Context.MODE_PRIVATE
            ).getBoolean("theme", false)
        ) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
        when (getSharedPreferences("Lang", Context.MODE_PRIVATE).getString("lang", "uz")) {
            "uz" -> Settings.getLang = "uz"
            "en" -> Settings.getLang = "en"
            "ru" -> Settings.getLang = "ru"
        }
    }
}