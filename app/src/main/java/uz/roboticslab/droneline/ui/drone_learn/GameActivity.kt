package uz.roboticslab.droneline.ui.drone_learn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import uz.roboticslab.droneline.R
import uz.roboticslab.droneline.databinding.ActivityGameBinding
import uz.roboticslab.droneline.skybox.CustomGLSurfaceView

class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id = intent.getIntExtra("type", 1) as Int
        val view = CustomGLSurfaceView(id, this)
        binding.skybox.addView(view)
        if (id != 1) {
            binding.controlDrone.visibility = View.GONE
            binding.droneLottie.setAnimation(R.raw.drone)
        }
    }

    override fun onStart() {
        super.onStart()
        window.statusBarColor = ContextCompat.getColor(this, R.color.backgroundColor_night)
    }
}