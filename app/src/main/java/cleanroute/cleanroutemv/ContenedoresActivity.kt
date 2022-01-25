package cleanroute.cleanroutemv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import cleanroute.cleanroutemv.Modelos.Contenedores
import cleanroute.cleanroutemv.Modelos.Respuestas
import cleanroute.cleanroutemv.Servicios.ApiUrlCleanRoute
import cleanroute.cleanroutemv.Servicios.InterCleanRoute

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ContenedoresActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    lateinit var contenedoresLoc : List<Contenedores>
    var gson: Gson? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contenedores)
        gson= GsonBuilder().setLenient().create()


        var MunID:String = "1234567M"

        val retrofit= Retrofit.Builder()
            .baseUrl(ApiUrlCleanRoute.BaseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()


        var service=retrofit.create(InterCleanRoute::class.java)
        var call=service.getContenedores()

        call.enqueue(object: Callback<Respuestas>{
            override fun onFailure(call: Call<Respuestas>?, t: Throwable?) {
                Log.e("onFailure",t!!.message)
            }

            override fun onResponse(call: Call<Respuestas>?, response: Response<Respuestas>?) {
                if(response!!.isSuccessful) {
                    Log.e("onResponse",response!!.body().toString())
                    if (response.body().status) {
                        contenedoresLoc = response.body().data
                        onMarketsContenedores(contenedoresLoc)
                    }

                }

            }

        })

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
        mMap.getUiSettings().setZoomControlsEnabled(true)
        var tamazula = LatLng(19.68006, -103.2514)
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tamazula,18f))
    }
    fun onMarketsContenedores(Data: List <Contenedores>) {
        for (item : Contenedores in Data) {
            mMap.addMarker(
                MarkerOptions().position(
                    LatLng(item.Latitud, item.Longitud)
                ).title(item.Tipo))
    }
}}
