package uz.roboticslab.droneline.utils

import android.app.Activity
import android.app.DownloadManager
import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.os.Handler
import android.os.Vibrator
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.webkit.MimeTypeMap
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.fragment.app.FragmentActivity
import java.util.*

import android.view.LayoutInflater
import android.widget.TextView
import uz.roboticslab.droneline.R


fun FragmentActivity.statusBarColor(
    @ColorInt statusBarColor: Int,
    @ColorInt navigationBarColor: Int,
    darkStatusBarTint: Boolean
) {
    //statusBarColor
    val win: Window = (window).also {
        it.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            it.statusBarColor = statusBarColor
        }
        //navigatorBarColor
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            it.navigationBarColor = navigationBarColor
//        }
    }

    val dec = win.decorView
    if (darkStatusBarTint) {
        dec.systemUiVisibility = dec.systemUiVisibility or
                View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    } else {
        dec.systemUiVisibility = 0
    }
}

fun vibrate(context: Context, duration: Int) {
    val vibration: Vibrator =
        context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    vibration.vibrate(duration.toLong())
}

fun dipToPixels(context: Context, dipValue: Float): Float {
    val metrics: DisplayMetrics = context.resources.displayMetrics
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, metrics)
}

fun downloadFile(context: Context, fileName: String, url: String) {
    val downloadUrl = Uri.parse(url)
    val manager: DownloadManager =
        context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

    try {
        val requset: DownloadManager.Request = DownloadManager.Request(downloadUrl)
        requset.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE)
            .setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI)
            .setTitle(fileName)
            .setDescription("Downloading $fileName")
            .setAllowedOverMetered(true)
            .setAllowedOverRoaming(true)
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .setDestinationInExternalPublicDir(
                Environment.DIRECTORY_DOWNLOADS, downloadUrl.toString()
            )
            .setMimeType(getMimeType(context, downloadUrl))
        manager.enqueue(requset)
        toast(context, "Download started")
    } catch (e: Exception) {
        toast(context, "Something went wrong!!")
    }
}

private fun getMimeType(context: Context, uri: Uri): String {
    val resolver = context.contentResolver as ContentResolver
    val mimeTypeMap = MimeTypeMap.getSingleton() as MimeTypeMap
    return mimeTypeMap.getExtensionFromMimeType(resolver.getType(uri)).toString()
}

fun changeMoneyType(sum: String): String {
    var reversedSum = ""
    for (i in sum.length - 1 downTo 0) {
        reversedSum += sum[i]
    }
    var changedSum = ""
    if (reversedSum.length > 3) {
        var k = 2
        for (i in reversedSum.indices) {
            changedSum += reversedSum[i]
            if (i >= k) {
                changedSum += " "
                k += 3
            }
        }
        reversedSum = ""
        for (i in changedSum.length - 1 downTo 0) {
            reversedSum += changedSum[i]
        }
    } else {
        reversedSum = sum
    }
    return reversedSum.trim()
}

fun View?.blockClickable(blockTimeMilles: Long = 500) {
    this?.isClickable = false
    Handler().postDelayed({ this?.isClickable = true }, blockTimeMilles)
}

fun errorToast(context: Context, message: String) {
    val layoutInflater = LayoutInflater.from(context)
    val view = layoutInflater.inflate(R.layout.error_toast, null)
    val textView = view.findViewById<TextView>(R.id.message)
    textView.text = message
    val myToast = Toast(context)
    myToast.view = view
    myToast.duration = Toast.LENGTH_LONG
    myToast.show()
}

fun toast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

fun dismissKeyboard(activity: Activity) {
    val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    if (null != activity.currentFocus) imm.hideSoftInputFromWindow(
        activity.currentFocus!!
            .applicationWindowToken, 0
    )
}

fun View.showKeyboard() {
    this.requestFocus()
    val inputMethodManager =
        context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}


