package com.lwjlol.privacyhook.demo

import android.content.BroadcastReceiver
import android.content.ClipboardManager
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.hardware.SensorManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.lwjlol.privacyhook.PrivacyHooker

/**
 * @author luwenjie on 2023/5/29 13:51:41
 */
class Main : AppCompatActivity() {
    private var agree = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        PrivacyHooker.isUserAgreed = {
            agree
        }
        registerReceiver(MyBroadcastReceiver(), IntentFilter());
        // test hook
        val r = packageManager.getInstalledPackages(2);
        val  r2 = packageManager.getInstalledApplications(1);
        packageManager.getInstalledModules(3);
        packageManager.getInstalledPackages(PackageManager.PackageInfoFlags.of(1));
        packageManager.getInstalledApplications(PackageManager.ApplicationInfoFlags.of(1));

        testSensor();
        val s = Build.getSerial();
        val dialog = AlertDialog.Builder(this)
            .setPositiveButton(
                "同意$r,$r2 $s",
                DialogInterface.OnClickListener { dialog, which ->
                    agree = true
                },
            )
            .setNegativeButton(
                "不同意",
                DialogInterface.OnClickListener { dialog, which ->
                    agree = false
                },
            )
            .setMessage("是否同意隐私协议？")

        dialog.show()
    }

    companion object {
        private const val TAG = "Main"
    }


    fun  testSensor(){
        val  clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager;
        val  a = clipboardManager.primaryClipDescription
        println(a)
    }
}

class  MyBroadcastReceiver : BroadcastReceiver(){
    override fun onReceive(p0: Context?, p1: Intent?) {

    }

}
