## android_privacy_hook

基于 Booster 对隐私 api 进行 hook，用户同意之前返回空值。同意之后才调用原有的 api。



## 使用

root build.gradle:
```gradle
buildscript {
    ext.booster_version = '4.16.2'
    ext.privacyhook_version = '0.0.1'
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        // 依赖 booster
        classpath "com.didiglobal.booster:booster-gradle-plugin:$booster_version"
        // privacyhook:transform
        classpath "com.lwjlol.privacyhook:transform:$privacyhook_version"
    }
}
```

app 的 build.gradle
```gradle
dependencies {
    implementation 'com.lwjlol.privacyhook:core:0.0.1'
}
```




设置 isUserAgreed 函数，获取当前是否同意：
```kotlin
// 设置 isUserAgreed 
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
```