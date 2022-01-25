package cleanroute.cleanroutemv

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.location.Location
import android.location.LocationListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import cleanroute.cleanroutemv.Modelos.RespuestaReportes
import cleanroute.cleanroutemv.Modelos.SolicitudReportes
import cleanroute.cleanroutemv.Servicios.ApiUrlCleanRoute
import cleanroute.cleanroutemv.Servicios.InterCleanRoute
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.location.LocationManager
import android.widget.Toast

import androidx.core.app.ActivityCompat
import android.content.pm.PackageManager
import android.graphics.Color
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    var locationManager: LocationManager? = null
    var locationListener: LocationListener? = null

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        //para conectarme con la base de datos
        super.onCreate(savedInstanceState)
        var gson = GsonBuilder().setLenient().create()
        val retrofit = Retrofit.Builder()
            .baseUrl(ApiUrlCleanRoute.BaseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        locationManager = this.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        locationListener = object : LocationListener {
            override fun onLocationChanged(location: Location) {
            }

            override fun onStatusChanged(s: String, i: Int, bundle: Bundle) {}
            override fun onProviderEnabled(s: String) {}
            override fun onProviderDisabled(s: String) {}
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1)
        }



        //para brincar de activity
        setContentView(R.layout.activity_main)
        var ibRutas = findViewById(R.id.ibRutas) as ImageButton
        ibRutas.setOnClickListener{
            startActivity(Intent(this@MainActivity,RutasActivity::class.java))
        }
        var ibContenedores = findViewById(R.id.ibContenedores) as ImageButton
        ibContenedores.setOnClickListener{
            startActivity(Intent(this@MainActivity,ContenedoresActivity::class.java))
        }
        var ibRecicladoras = findViewById(R.id.ibRecicladoras) as ImageButton
        ibRecicladoras.setOnClickListener{
            startActivity(Intent(this@MainActivity,RecicladoraActivity::class.java))
        }
        var ibConcientizate = findViewById(R.id.ibConcientizate) as ImageButton
        ibConcientizate.setOnClickListener{
            startActivity(Intent(this@MainActivity,ConcientizateActivity::class.java))
        }
        var ibReportar = findViewById(R.id.ibReportar) as ImageButton
        ibReportar.setOnClickListener {
            locationManager!!.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0f, locationListener)
            val lastKnownLocation = locationManager!!.getLastKnownLocation(LocationManager.GPS_PROVIDER)



    var solReporte = SolicitudReportes("1234567M", lastKnownLocation.latitude,lastKnownLocation.longitude,"Encontre basura por mi ubicacion")
            var service = retrofit.create(InterCleanRoute::class.java)
            var call = service.getReportes(solReporte)
            call.enqueue(object: Callback<RespuestaReportes>{
                override fun onFailure(call: Call<RespuestaReportes>?, t: Throwable?) {
                    Log.e("Error", t?.message)
                }

                override fun onResponse(
                    call: Call<RespuestaReportes>?,
                    response: Response<RespuestaReportes>?
                ) {
                    if (response!!.isSuccessful && response.body().status) {
                        Toast.makeText(
                            this@MainActivity,
                            "Tu reporte fue enviado",
                            Toast.LENGTH_LONG
                        )
                        var mAlertDialog = AlertDialog.Builder(this@MainActivity)
                        mAlertDialog.setTitle("CleanRoute") //Dialogo de la alert
                        mAlertDialog.setMessage("Tu reporte fué enviado")
                        //Color.parseColor("#A5DC86")
                        mAlertDialog.setIcon(R.mipmap.logo_inicial); //icono de la alert
                        //agregar boton positivo a la alert
                        mAlertDialog.setPositiveButton("Aceptar") { dialog, id->
                        }
                        mAlertDialog.show()// muestra la alert
                    }

                }
            })

//Para cerrar sesion
        }
        var ibCerrar = findViewById(R.id.ibCerrar) as ImageButton
        ibCerrar.setOnClickListener{
            startActivity(Intent(this@MainActivity,LoginActivity::class.java))
        }
    }
}
