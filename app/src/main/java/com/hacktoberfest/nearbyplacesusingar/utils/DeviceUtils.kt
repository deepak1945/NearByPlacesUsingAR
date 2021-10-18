package com.hacktoberfest.nearbyplacesusingar.utils

import android.app.ActivityManager
import android.content.Context

fun isSupportedDevice(context: Context): Boolean {
    val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
    val openGlVersionString = activityManager.deviceConfigurationInfo.glEsVersion
    if (openGlVersionString.toDouble() < 3.0) {
        ViewUtils.toast(context, "Sceneform requires OpenGL ES 3.0 or later")
        return false
    }
    return true
}