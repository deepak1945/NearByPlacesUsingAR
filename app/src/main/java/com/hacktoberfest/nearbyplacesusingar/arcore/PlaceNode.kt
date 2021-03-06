package com.appthon.dxc.findnearbyplacesar.ar

import android.content.Context
import android.os.Build
import android.view.View
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.google.ar.sceneform.Node
import com.google.ar.sceneform.rendering.ViewRenderable
import com.hacktoberfest.nearbyplacesusingar.R
import com.hacktoberfest.nearbyplacesusingar.model.Place

//Class for holding places objects
class PlaceNode(
    val context: Context,
    val place: Place?
) : Node() {

    private var placeRenderable: ViewRenderable? = null
    private var textViewPlace: TextView? = null

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onActivate() {
        super.onActivate()

        if (scene == null) {
            return
        }

        if (placeRenderable != null) {
            return
        }

        ViewRenderable.builder()
            .setView(context, R.layout.place_view)
            .build()
            .thenAccept { renderable ->
                setRenderable(renderable)
                placeRenderable = renderable

                place?.let {
                    textViewPlace = renderable.view.findViewById(R.id.placeName)
                    textViewPlace?.text = it.name
                }
            }
    }

    fun showInfoWindow() {
        // Show text
        textViewPlace?.let {
            it.visibility = if (it.visibility == View.VISIBLE) View.GONE else View.VISIBLE
        }

        // Hide text for other nodes
        this.parent?.children?.filter {
            it is PlaceNode && it != this
        }?.forEach {
            (it as PlaceNode).textViewPlace?.visibility = View.GONE
        }
    }
}