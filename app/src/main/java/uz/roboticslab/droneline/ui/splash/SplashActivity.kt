package uz.roboticslab.droneline.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import androidx.core.content.ContextCompat
import uz.roboticslab.droneline.MainActivity
import uz.roboticslab.droneline.R
import uz.roboticslab.droneline.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val anim = AnimationUtils.loadAnimation(this, R.anim.anim)
        binding.appName.animation = anim
        binding.splashImage.animation = anim
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }

    override fun onStart() {
        super.onStart()
        this.window?.statusBarColor =
            ContextCompat.getColor(this, R.color.splash_color)
    }
}