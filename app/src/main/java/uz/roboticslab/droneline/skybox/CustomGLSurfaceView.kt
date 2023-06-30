package uz.roboticslab.droneline.skybox

import android.content.Context
import android.opengl.GLSurfaceView
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.View
import com.example.droneline.skybox.OpenGLRenderer

class CustomGLSurfaceView(id: Int, context: Context) : GLSurfaceView(context),
    View.OnTouchListener {
    val renderer: OpenGLRenderer

    //Touch
    var previousX = 0f
    var previousY = 0f
    private val mScaleDetector: ScaleGestureDetector
    private var mScaleFactor = 3.0f

    private inner class ScaleListener : ScaleGestureDetector.SimpleOnScaleGestureListener() {
        override fun onScale(detector: ScaleGestureDetector): Boolean {
            mScaleFactor *= detector.scaleFactor
            mScaleFactor = Math.max(0.1f, Math.min(mScaleFactor, 8.5f))
            return true
        }
    }

    override fun onTouch(view: View, motionEvent: MotionEvent): Boolean {
        return if (motionEvent != null) {
            mScaleDetector.onTouchEvent(motionEvent)
            if (motionEvent.action == MotionEvent.ACTION_DOWN) {
                previousX = motionEvent.x
                previousY = motionEvent.y
            } else if (motionEvent.action == MotionEvent.ACTION_MOVE) {
                val deltaX = motionEvent.x - previousX
                val deltaY = motionEvent.y - previousY
                previousX = motionEvent.x
                previousY = motionEvent.y
                queueEvent { renderer.changeMyView(deltaX, deltaY, mScaleFactor) }
            }
            true
        } else {
            false
        }
    }

    init {
        setEGLContextClientVersion(2)
        renderer = OpenGLRenderer(id, context)
        setRenderer(renderer)
        setOnTouchListener(this)
        mScaleDetector = ScaleGestureDetector(context, ScaleListener())
    }
}