package com.lwjlol.transform

import com.didiglobal.booster.kotlinx.asIterable
import com.didiglobal.booster.kotlinx.touch
import com.didiglobal.booster.transform.TransformContext
import com.didiglobal.booster.transform.asm.ClassTransformer
import com.google.auto.service.AutoService
import org.objectweb.asm.Opcodes.INVOKESTATIC
import org.objectweb.asm.Opcodes.INVOKEVIRTUAL
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.MethodInsnNode
import java.io.PrintWriter
import java.util.regex.Pattern

/**
 * @author luwenjie on 2022/9/29 20:41:48
 */
@AutoService(ClassTransformer::class)
class PrivacyTransformer : ClassTransformer {
    override val name: String = "transform-privacy"
    private lateinit var logger: PrintWriter

    override fun onPreTransform(context: TransformContext) {
        this.logger = getReport(context, "report.txt").touch().printWriter()
    }

    override fun onPostTransform(context: TransformContext) {
        this.logger.close()
    }

    private val whiteList = listOf(hookOwner, "androidx/core", "androidx/media")

    override fun transform(context: TransformContext, klass: ClassNode): ClassNode {
        if (Pattern.matches(R_REGEX, klass.name)) return klass
        if (whiteList.any { klass.name.startsWith(it) }) {
            return klass
        }
        privacyMetaList.forEach { meta ->
            klass.methods.forEach { method ->
                method.instructions?.iterator()?.asIterable()?.forEach { insnNode ->
                    if (insnNode.opcode == INVOKEVIRTUAL || insnNode.opcode == INVOKESTATIC) {
                        (insnNode as MethodInsnNode).apply {
                            if (owner == meta.owner &&
                                name == meta.name &&
                                desc == meta.desc
                            ) {
                                logger.println("hook ${klass.name} ${method.name} ${method.desc} \n--> $owner $name $desc")
                                insnNode.owner = meta.hookOwner
                                insnNode.opcode = INVOKESTATIC
                                insnNode.desc = meta.hookDesc
                            }
                        }
                    }
                }
            }
        }

        return klass
    }

    companion object {
        private const val TAG = "AppPrivacyTransformer"
    }
}

private const val R_REGEX = ".*/R\\\$.*|.*/R\\.*"

private const val hookOwner = "com/lwjlol/privacyhook/ShadowPrivacy"

private val privacyMetaList = listOf(
    MetaData(
        owner = "android/telephony/TelephonyManager",
        name = "getDeviceId",
        desc = "()Ljava/lang/String;",
        hookOwner = hookOwner,
        hookDesc = "(Landroid/telephony/TelephonyManager;)Ljava/lang/String;",
    ),
    MetaData(
        owner = "android/telephony/TelephonyManager",
        name = "getImei",
        desc = "()Ljava/lang/String;",
        hookOwner = hookOwner,
        hookDesc = "(Landroid/telephony/TelephonyManager;)Ljava/lang/String;",
    ),
    MetaData(
        owner = "android/telephony/TelephonyManager",
        name = "getSubscriberId",
        desc = "()Ljava/lang/String;",
        hookOwner = hookOwner,
        hookDesc = "(Landroid/telephony/TelephonyManager;)Ljava/lang/String;",
    ),
    MetaData(
        owner = "android/telephony/TelephonyManager",
        name = "getSimSerialNumber",
        desc = "()Ljava/lang/String;",
        hookOwner = hookOwner,
        hookDesc = "(Landroid/telephony/TelephonyManager;)Ljava/lang/String;",
    ),
    MetaData(
        owner = "android/provider/Settings\$System",
        name = "getString",
        desc = "(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;",
        hookOwner = hookOwner,
        hookDesc = "(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;",
    ),
    MetaData(
        owner = "android/provider/Settings\$Secure",
        name = "getString",
        desc = "(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;",
        hookOwner = hookOwner,
        hookDesc = "(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;",
    ),
    MetaData(
        owner = "java/net/NetworkInterface",
        name = "getHardwareAddress",
        desc = "()[B",
        hookOwner = hookOwner,
        hookDesc = "(Ljava/net/NetworkInterface;)[B",
    ),
    MetaData(
        owner = "android/net/wifi/WifiInfo",
        name = "getMacAddress",
        desc = "()Ljava/lang/String;",
        hookOwner = hookOwner,
        hookDesc = "(Landroid/net/wifi/WifiInfo;)Ljava/lang/String;",
    ),
    MetaData(
        owner = "android/net/wifi/WifiInfo",
        name = "getSSID",
        desc = "()Ljava/lang/String;",
        hookOwner = hookOwner,
        hookDesc = "(Landroid/net/wifi/WifiInfo;)Ljava/lang/String;",
    ),
    MetaData(
        owner = "android/net/wifi/WifiInfo",
        name = "getBSSID",
        desc = "()Ljava/lang/String;",
        hookOwner = hookOwner,
        hookDesc = "(Landroid/net/wifi/WifiInfo;)Ljava/lang/String;",
    ),
    MetaData(
        owner = "android/net/wifi/WifiInfo",
        name = "getNetworkId",
        desc = "()I",
        hookOwner = hookOwner,
        hookDesc = "(Landroid/net/wifi/WifiInfo;)I",
    ),
    MetaData(
        owner = "android/net/wifi/WifiInfo",
        name = "getRssi",
        desc = "()I",
        hookOwner = hookOwner,
        hookDesc = "(Landroid/net/wifi/WifiInfo;)I",
    ),
    MetaData(
        owner = "android/content/pm/PackageManager",
        name = "getPackageInfo",
        desc = "(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;",
        hookOwner = hookOwner,
        hookDesc = "(Landroid/content/pm/PackageManager;Ljava/lang/String;I)Landroid/content/pm/PackageInfo;",
    ),
)

private class MetaData(
    val owner: String,
    val name: String,
    val desc: String,
    val hookOwner: String,
    val hookDesc: String,
)
