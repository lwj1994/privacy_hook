package com.lwjlol.privacyhook.demo

import android.content.DialogInterface
import android.os.Bundle
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
        val dialog = AlertDialog.Builder(this)
            .setPositiveButton(
                "同意",
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
}
