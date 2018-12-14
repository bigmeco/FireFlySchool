package com.bigmeco.fireflyschoo.screens.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.bigmeco.fireflyschoo.R
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.fragment_map.*

private var mMap: MapView? = null


class MapFragment : Fragment(), OnMapReadyCallback {


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mMap?.onSaveInstanceState(outState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_map, container, false)
        activity?.let { activity ->


            mMap = view.findViewById(R.id.mapView) as MapView
            mMap?.onCreate(savedInstanceState)
            mMap?.getMapAsync(this)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


    override fun onMapReady(googleMap: GoogleMap) {
        activity?.let { activity ->
            googleMap.addMarker(MarkerOptions()
                    .position(LatLng(59.735039, 30.618913))
                    .title("Ладожский б-р, 1")
                    .snippet("СВЕТЛЯЧОК - центр развития"))

            googleMap.addMarker(MarkerOptions()
                    .position(LatLng(59.769740, 30.797825))
                    .title("ул. Щурова, 3 корпус 1")
                    .snippet("СВЕТЛЯЧОК - центр развития детей"))

            googleMap.addMarker(MarkerOptions()
                    .position(LatLng(59.541993, 30.878453))
                    .title("Советская ул., 9А")
                    .snippet("СВЕТЛЯЧОК - центр развития"))


            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(LatLng(59.653202, 30.755674), 10f))
        }
    }


    override fun onResume() {
        super.onResume()
        mMap?.onResume()
    }

    override fun onPause() {
        super.onPause()
        mMap?.onPause()
    }

    override fun onStart() {
        super.onStart()
        mMap?.onStart()
    }

    override fun onStop() {
        super.onStop()
        mMap?.onStop()

    }

    override fun onDestroy() {
        super.onDestroy()
        mMap?.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mMap?.onLowMemory()
    }
}
