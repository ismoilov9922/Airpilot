package uz.roboticslab.droneline.skybox

import android.opengl.GLES20
import com.example.droneline.skybox.OpenGLRenderer.Companion.loadShader
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.FloatBuffer
import java.nio.ShortBuffer

class SkyBox {
    //Geometry
    private val vertexBuffer: FloatBuffer
    private val indexBuffer: ShortBuffer
    private val POSITION_COUNT = 3 //number of position coordinates
    private val COORDINATES_PER_VERTEX = POSITION_COUNT

    //Rendering
    private val vertexShaderCode = "attribute vec3 aPosition;" +
            "uniform mat4 uMVPMatrix;" +
            "varying vec3 vPosition;" +
            "void main() {" +
            "vPosition = aPosition;" +
            "gl_Position = uMVPMatrix*vec4(aPosition, 1.0);" +
            "gl_Position = gl_Position.xyww;" +
            "}"
    private val fragmentShaderCode = "precision mediump float;" +
            "uniform samplerCube uTextureUnit;" +
            "varying vec3 vPosition;" +
            "void main() {" +
            "  gl_FragColor = textureCube(uTextureUnit,vPosition);" +
            "}"

    //Draw
    private val mProgram: Int
    private var mPositionHandle = 0
    private var mTextureUnitHandle = 0
    private var mMVPMatrixHandle = 0
    private val vertexStride = COORDINATES_PER_VERTEX * 4 // 4 bytes per vertex
    fun draw(mvpMatrix: FloatArray?, textureID: Int) {
        GLES20.glUseProgram(mProgram)
        mPositionHandle = GLES20.glGetAttribLocation(mProgram, "aPosition")
        mTextureUnitHandle = GLES20.glGetUniformLocation(mProgram, "uTextureUnit")
        mMVPMatrixHandle = GLES20.glGetUniformLocation(mProgram, "uMVPMatrix")
        GLES20.glUniformMatrix4fv(mMVPMatrixHandle, 1, false, mvpMatrix, 0)
        vertexBuffer.position(0)
        indexBuffer.position(0)
        GLES20.glVertexAttribPointer(
            mPositionHandle, POSITION_COUNT,
            GLES20.GL_FLOAT, false, vertexStride, vertexBuffer
        )
        GLES20.glEnableVertexAttribArray(mPositionHandle)
        GLES20.glActiveTexture(GLES20.GL_TEXTURE0)
        GLES20.glBindTexture(GLES20.GL_TEXTURE_CUBE_MAP, textureID)
        GLES20.glUniform1i(mTextureUnitHandle, 0)
        GLES20.glDrawElements(GLES20.GL_TRIANGLES, 36, GLES20.GL_UNSIGNED_SHORT, indexBuffer)
        GLES20.glBindTexture(GLES20.GL_TEXTURE_CUBE_MAP, 0)
        GLES20.glDisableVertexAttribArray(mPositionHandle)
    }

    companion object {
        var cubeCoords = floatArrayOf(
            -1f,
            1f,
            1f,
            1f,
            1f,
            1f,
            -1f,
            -1f,
            1f,
            1f,
            -1f,
            1f,
            -1f,
            1f,
            -1f,
            1f,
            1f,
            -1f,
            -1f,
            -1f,
            -1f,
            1f,
            -1f,
            -1f
        )
        var indexArray = shortArrayOf( // Front
            1, 3, 0,
            0, 3, 2,  // Back
            4, 6, 5,
            5, 6, 7,  // Left
            0, 2, 4,
            4, 2, 6,  // Right
            5, 7, 1,
            1, 7, 3,  // Top
            5, 1, 4,
            4, 1, 0,  // Bottom
            6, 2, 7,
            7, 2, 3
        )
    }

    init {
        val bb = ByteBuffer.allocateDirect(cubeCoords.size * 4) //4 bytes for 1 float
        bb.order(ByteOrder.nativeOrder())
        vertexBuffer = bb.asFloatBuffer()
        vertexBuffer.put(cubeCoords)
        val ib = ByteBuffer.allocateDirect(indexArray.size * 2) //2 bytes for 1 short
        ib.order(ByteOrder.nativeOrder())
        indexBuffer = ib.asShortBuffer()
        indexBuffer.put(indexArray)
        val vertexShader = loadShader(GLES20.GL_VERTEX_SHADER, vertexShaderCode)
        val fragmentShader = loadShader(GLES20.GL_FRAGMENT_SHADER, fragmentShaderCode)
        mProgram = GLES20.glCreateProgram()
        GLES20.glAttachShader(mProgram, vertexShader)
        GLES20.glAttachShader(mProgram, fragmentShader)
        GLES20.glLinkProgram(mProgram)
    }
}