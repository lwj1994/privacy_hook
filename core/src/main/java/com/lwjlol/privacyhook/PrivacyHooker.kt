package com.lwjlol.privacyhook

/**
 * @author luwenjie on 2022/9/29 20:21:34
 */
object PrivacyHooker {
    @JvmStatic
    var isUserAgreed: () -> Boolean = { false }


    // AppStore 是否审核通过。某些情况下只在审核时屏蔽掉。比如调用 api 频率过快
    // 需要自行监测是否过审，如果无法监测直接传 false
    @JvmStatic
    var isAppStoreReviewed: () -> Boolean = { false }
}
