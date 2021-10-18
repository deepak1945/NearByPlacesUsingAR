
package com.hacktoberfest.nearbyplacesusingar.arcore

import android.Manifest
import com.google.ar.sceneform.ux.ArFragment

//Fragment class for showing AR Nodes
class PlacesArFragment : ArFragment() {

    override fun getAdditionalPermissions(): Array<String> =
        listOf(Manifest.permission.ACCESS_FINE_LOCATION).toTypedArray()
}
