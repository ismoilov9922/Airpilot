package com.example.droneline.skybox

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.opengl.GLES20
import android.opengl.GLSurfaceView
import android.opengl.GLUtils
import android.opengl.Matrix
import uz.roboticslab.droneline.R
import uz.roboticslab.droneline.skybox.SkyBox
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

class OpenGLRenderer(private val id: Int, var context: Context) : GLSurfaceView.Renderer {
    private var ratio = 0f
    private var xRotation = 0f
    private var yRotation = 0f
    private var skyBox: SkyBox? = null
    private val mMVPMatrix = FloatArray(16)
    private val mProjectionMatrix = FloatArray(16)
    private val mViewMatrix = FloatArray(16)
    private val mModelMatrix = FloatArray(16)
    private val textureObjectID = IntArray(1)
    override fun onSurfaceCreated(gl10: GL10, eglConfig: EGLConfig) {
        GLES20.glClearColor(0.9f, 1f, 0.9f, 1f)
        skyBox = SkyBox()
        //GLES20.glEnable(GLES20.GL_DEPTH_TEST);
        GLES20.glGenTextures(1, textureObjectID, 0)
        val options = BitmapFactory.Options()
        options.inScaled = false
        GLES20.glActiveTexture(GLES20.GL_TEXTURE0)
        var cubeResorces: IntArray
        if (id == 1) {
            cubeResorces = intArrayOf(
                R.drawable.mobile_l, R.drawable.mobile_r, R.drawable.mobile_d, R.drawable.mobile_u,
                R.drawable.mobile_b, R.drawable.mobile_f
            )
        } else {
            cubeResorces = intArrayOf(
                R.drawable.negx2, R.drawable.posx2, R.drawable.negy2, R.drawable.posy2,
                R.drawable.negz2, R.drawable.posz2
            )
        }
        val positionInCube = intArrayOf(
            GLES20.GL_TEXTURE_CUBE_MAP_NEGATIVE_X,
            GLES20.GL_TEXTURE_CUBE_MAP_POSITIVE_X,
            GLES20.GL_TEXTURE_CUBE_MAP_NEGATIVE_Y,
            GLES20.GL_TEXTURE_CUBE_MAP_POSITIVE_Y,
            GLES20.GL_TEXTURE_CUBE_MAP_NEGATIVE_Z,
            GLES20.GL_TEXTURE_CUBE_MAP_POSITIVE_Z
        )
        var cubeBitmap: Bitmap
        GLES20.glBindTexture(GLES20.GL_TEXTURE_CUBE_MAP, textureObjectID[0])
        GLES20.glTexParameteri(
            GLES20.GL_TEXTURE_CUBE_MAP,
            GLES20.GL_TEXTURE_MIN_FILTER,
            GLES20.GL_LINEAR
        )
        GLES20.glTexParameteri(
            GLES20.GL_TEXTURE_CUBE_MAP,
            GLES20.GL_TEXTURE_MAG_FILTER,
            GLES20.GL_LINEAR
        )
        GLES20.glTexParameteri(
            GLES20.GL_TEXTURE_CUBE_MAP,
            GLES20.GL_TEXTURE_WRAP_S,
            GLES20.GL_CLAMP_TO_EDGE
        )
        GLES20.glTexParameteri(
            GLES20.GL_TEXTURE_CUBE_MAP,
            GLES20.GL_TEXTURE_WRAP_T,
            GLES20.GL_CLAMP_TO_EDGE
        )
        for (i in 0..5) {
            cubeBitmap = BitmapFactory.decodeResource(context.resources, cubeResorces[i], options)
            GLUtils.texImage2D(positionInCube[i], 0, cubeBitmap, 0)
            cubeBitmap.recycle()
        }
        GLES20.glBindTexture(GLES20.GL_TEXTURE_CUBE_MAP, 0) //Unbind
    }

    override fun onSurfaceChanged(gl10: GL10, w: Int, h: Int) {
        GLES20.glViewport(0, 0, w, h)
        xRotation = 0f
        yRotation = 0f
        ratio = w.toFloat() / h
        Matrix.setIdentityM(mModelMatrix, 0)
        Matrix.setLookAtM(
            mViewMatrix, 0, 0.0f, 0.0f, 0.001f,
            0f, 0f, 0f, 0f, 1f, 0f
        )
        Matrix.perspectiveM(mProjectionMatrix, 0, 60f, ratio, 0.0f, 2f)
        Matrix.multiplyMM(mMVPMatrix, 0, mViewMatrix, 0, mModelMatrix, 0)
        Matrix.multiplyMM(mMVPMatrix, 0, mProjectionMatrix, 0, mMVPMatrix, 0)
    }

    fun changeMyView(dX: Float, dY: Float, scale: Float) {
        xRotation += dX / 20f
        yRotation += dY / 20f
        if (yRotation < -90f) {
            yRotation = -90f
        } else if (yRotation > 90f) {
            yRotation = 90f
        }
        Matrix.setIdentityM(mModelMatrix, 0)
        Matrix.rotateM(mModelMatrix, 0, -yRotation, 1f, 0f, 0f)
        Matrix.rotateM(mModelMatrix, 0, -xRotation, 0f, 1f, 0f)
        Matrix.setLookAtM(
            mViewMatrix, 0,
            0.0f, 0.0f, 0.0001f,
            0f, 0f, 0f,
            0f, 1f, 0f
        )
        Matrix.perspectiveM(mProjectionMatrix, 0, 90f - 10f * scale, ratio, 0.0f, 2f)
        Matrix.multiplyMM(mMVPMatrix, 0, mViewMatrix, 0, mModelMatrix, 0)
        Matrix.multiplyMM(mMVPMatrix, 0, mProjectionMatrix, 0, mMVPMatrix, 0)
    }

    override fun onDrawFrame(gl10: GL10) {
        //GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT|GLES20.GL_DEPTH_BUFFER_BIT);
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT)
        skyBox?.draw(mMVPMatrix, textureObjectID[0])
    }

    companion object {
        @JvmStatic
        fun loadShader(type: Int, shaderCode: String?): Int {
            val shader = GLES20.glCreateShader(type)
            GLES20.glShaderSource(shader, shaderCode)
            GLES20.glCompileShader(shader)
            return shader
        }
    }
}