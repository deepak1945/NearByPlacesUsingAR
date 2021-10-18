package com.hacktoberfest.nearbyplacesusingar.utils

import android.content.Context
import android.widget.Toast

//Utility class for holding common utils methods
class ViewUtils {
    companion object {
        fun toast(context: Context, msg: String) {
            Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
        }
    }
}