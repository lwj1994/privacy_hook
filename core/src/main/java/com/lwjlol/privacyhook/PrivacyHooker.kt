package com.lwjlol.privacyhook

/**
 * @author luwenjie on 2022/9/29 20:21:34
 */
object PrivacyHooker {
    @JvmStatic
    var isUserAgreed: () -> Boolean = { false }
}
