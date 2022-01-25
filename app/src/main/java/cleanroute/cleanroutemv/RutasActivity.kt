package cleanroute.cleanroutemv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*

class RutasActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rutas)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val primercamion = LatLng(19.681048, -103.250005)
        mMap.addMarker(MarkerOptions().position(primercamion).title("Camión #1, LUNES-SÁBADO: 9am"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(primercamion,18f))



        val segundocamion = LatLng(19.675512, -103.254254)
        mMap.addMarker(MarkerOptions().position(segundocamion).title("Camión #2, LUNES, MIÉRCOLES Y VIERNES: 7pm"))
        //mMap.addMarker(MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_marcador)).anchor(0.0f,0.0f).position(segundocamion))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(segundocamion,18f))
    }
}
