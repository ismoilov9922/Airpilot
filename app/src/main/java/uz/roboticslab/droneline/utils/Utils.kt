package uz.roboticslab.droneline.utils

import android.Manifest
import android.content.Context
import android.content.Intent
import android.net.Uri
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener

class Utils {
    fun permissionCall(context: Context, number: String) {
        Dexter.withContext(context)
            .withPermissions(
                Manifest.permission.CALL_PHONE,
                Manifest.permission.READ_CONTACTS,
                Manifest.permission.SEND_SMS
            )
            .withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(p0: MultiplePermissionsReport?) {
                    val callIntent = Intent(Intent.ACTION_CALL)
                    callIntent.data =
                        Uri.parse("tel:+998953401070")
                    context.startActivity(callIntent)
                }

                override fun onPermissionRationaleShouldBeShown(
                    p0: MutableList<PermissionRequest>?,
                    p1: PermissionToken?,
                ) {
                    p1?.continuePermissionRequest()
                    permissionCall(context, number)
                }
            }).check()
    }

}