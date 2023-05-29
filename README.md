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
