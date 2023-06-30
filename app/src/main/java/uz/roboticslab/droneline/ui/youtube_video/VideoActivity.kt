package uz.roboticslab.droneline.ui.youtube_video

import android.os.Bundle
import android.provider.Contacts.SettingsColumns.KEY
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayerFragment
import uz.roboticslab.droneline.R
import uz.roboticslab.droneline.databinding.ActivityVideoBinding
import uz.roboticslab.droneline.utils.Const

class VideoActivity : AppCompatActivity() {
    private var videoId: String = "P7ZnCgl5o2Y"
    private lateinit var binding: ActivityVideoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        videoId = intent.getStringExtra("videoId").toString()
        val youTubePlayerFragment =
            fragmentManager.findFragmentById(R.id.youtube_fragment1) as YouTubePlayerFragment
        youTubePlayerFragment.initialize(
            KEY,
            object : com.google.android.youtube.player.YouTubePlayer.OnInitializedListener {
                override fun onInitializationSuccess(
                    p0: com.google.android.youtube.player.YouTubePlayer.Provider?,
                    p1: com.google.android.youtube.player.YouTubePlayer?,
                    p2: Boolean,
                ) {
                    p1?.loadVideo(videoId)
                }

                override fun onInitializationFailure(
                    p0: com.google.android.youtube.player.YouTubePlayer.Provider?,
                    p1: YouTubeInitializationResult?,
                ) {
                }
            })
    }

    override fun onResume() {
        super.onResume()
        this.window?.statusBarColor =
            ContextCompat.getColor(this, R.color.black)
    }

    override fun onStart() {
        super.onStart()
        this.window?.statusBarColor =
            ContextCompat.getColor(this, R.color.black)
    }
}