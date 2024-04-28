package com.lwjlol.privacyhook;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentResolver;
import android.content.pm.ApplicationInfo;
import android.content.pm.ModuleInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"MissingPermission", "HardwareIds", "NewApi"})
public class ShadowPrivacy {
    private static final String TAG = "KurilPrivacyChecker";

    private static boolean isAgree() {
        Boolean agree;
        try {
            agree = PrivacyHooker.isUserAgreed().invoke();
        } catch (NullPointerException e) {
            agree = null;
        }
        if (agree == null) {
            return false;
        }
        return agree;
    }


    public static String getDeviceId(TelephonyManager telephonyManager) {
        if (isAgree()) {
            return telephonyManager.getDeviceId();
        }
        return "";
    }

    public static String getImei(TelephonyManager telephonyManager) {
        if (isAgree()) {
            return telephonyManager.getImei();
        }
        return "";
    }

    public static String getSimSerialNumber(TelephonyManager telephonyManager) {
        if (isAgree()) {
            return telephonyManager.getSimSerialNumber();
        }
        return "";
    }

    public static String getBuildSerial() {
        if (isAgree()) {
            return Build.getSerial();
        }
        return "";
    }

    public static String getMeid(TelephonyManager telephonyManager) {
        if (isAgree()) {
            return telephonyManager.getMeid();
        }
        return "";
    }

    public static String getSubscriberId(TelephonyManager telephonyManager) {
        if (isAgree()) {
            return telephonyManager.getSubscriberId();
        }
        return "";
    }

    public static byte[] getHardwareAddress(NetworkInterface networkInterface) {
        if (isAgree()) {
            try {
                return networkInterface.getHardwareAddress();
            } catch (SocketException e) {
                //
            }
        }
        return new byte[0];
    }

    public static String getMacAddress(WifiInfo wifiInfo) {
        if (isAgree()) {
            return wifiInfo.getMacAddress();
        }
        return "";
    }

    public static String getString(ContentResolver resolver, String name) {
        if (Settings.Secure.ANDROID_ID.equals(name)) {
            if (isAgree()) {
                return Settings.System.getString(resolver, name);
            }
            return "";
        }
        return Settings.System.getString(resolver, name);
    }

    public static String getSSID(WifiInfo wifiInfo) {
        if (isAgree()) {
            return wifiInfo.getSSID();
        }
        return "";
    }

    public static String getBSSID(WifiInfo wifiInfo) {
        if (isAgree()) {
            return wifiInfo.getBSSID();
        }
        return "";
    }

    public static int getRssi(WifiInfo wifiInfo) {
        if (isAgree()) {
            return wifiInfo.getRssi();
        }
        return 0;
    }

    public static int getNetworkId(WifiInfo wifiInfo) {
        if (isAgree()) {
            return wifiInfo.getNetworkId();
        }
        return 0;
    }

    public static PackageInfo getPackageInfo(PackageManager packageManager, String packageName, int flags) throws PackageManager.NameNotFoundException {
        if (isAgree()) {
            return packageManager.getPackageInfo(packageName, flags);
        }
        return new PackageInfo();
    }

    public static String getImei(TelephonyManager telephonyManager, int slotIndex) {
        if (isAgree()) {
            return telephonyManager.getImei(slotIndex);
        }
        return "";
    }

    public static String getSimOperator(TelephonyManager telephonyManager) {
        if (isAgree()) {
            return telephonyManager.getSimOperator();
        }
        return "";
    }

    public static boolean hasPrimaryClip(ClipboardManager clipboardManager) {
        if (isAgree()) {
            return clipboardManager.hasPrimaryClip();
        }
        return false;
    }

    public static ClipData getPrimaryClip(ClipboardManager clipboardManager) {
        if (isAgree()) {
            return clipboardManager.getPrimaryClip();
        }
        return null;
    }

    @SuppressLint("QueryPermissionsNeeded")
    public static List<PackageInfo> getInstalledPackages(PackageManager packageManager, int flags) {
        if (isAgree()) {
            return packageManager.getInstalledPackages(flags);
        }
        return new ArrayList<PackageInfo>();
    }

    @SuppressLint("QueryPermissionsNeeded")
    public static List<PackageInfo> getInstalledPackages(PackageManager packageManager, PackageManager.PackageInfoFlags flags) {
        if (isAgree()) {
            return packageManager.getInstalledPackages(flags);
        }
        return new ArrayList<PackageInfo>();
    }


    @SuppressLint("QueryPermissionsNeeded")
    public static List<ApplicationInfo> getInstalledApplications(PackageManager packageManager, int var1) {
        if (isAgree()) {
            return packageManager.getInstalledApplications(var1);
        }
        return new ArrayList<ApplicationInfo>();
    }

    @SuppressLint("QueryPermissionsNeeded")
    public static List<ApplicationInfo> getInstalledApplications(PackageManager packageManager, PackageManager.ApplicationInfoFlags var1) {
        if (isAgree()) {
            return packageManager.getInstalledApplications(var1);
        }
        return new ArrayList<ApplicationInfo>();
    }

    public static List<ModuleInfo> getInstalledModules(PackageManager packageManager, int flags) {
        if (isAgree()) {
            return packageManager.getInstalledModules(flags);
        }
        return new ArrayList<ModuleInfo>();
    }

}
