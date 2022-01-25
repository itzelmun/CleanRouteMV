package cleanroute.cleanroutemv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import cleanroute.cleanroutemv.Modelos.RespuestaRegister
import cleanroute.cleanroutemv.Modelos.SolicitudRegister
import cleanroute.cleanroutemv.Servicios.ApiUrlCleanRoute
import cleanroute.cleanroutemv.Servicios.InterCleanRoute
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RegisterActivity : AppCompatActivity() {

    lateinit var etNombre: EditText
    lateinit var etApellido: EditText
    lateinit var  etCorreo: EditText
    lateinit var  etClaveRegistro: EditText
    lateinit var bRegistro: Button
    var gson: Gson? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        gson = GsonBuilder().setLenient().create()


        val retrofit = Retrofit.Builder()
            .baseUrl(ApiUrlCleanRoute.BaseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        etNombre = findViewById(R.id.etNombre)
        etApellido = findViewById(R.id.etApellido)
        etCorreo = findViewById(R.id.etCorreo)
        etClaveRegistro = findViewById(R.id.etClaveRegistro)
        bRegistro = findViewById(R.id.bRegistro)

        bRegistro.setOnClickListener {
            if(etNombre.text.toString().isEmpty() and etApellido.text.toString().isEmpty()) {
                Toast.makeText(this@RegisterActivity,"Existen datos en blanco", Toast.LENGTH_LONG)
            } else {
                // mandar al servidor
                var MunicipioID: String = "1234567M"
                var solRegistro = SolicitudRegister(
                    MunicipioID,
                    etNombre.text.toString(),
                    etApellido.text.toString(),
                    etClaveRegistro.text.toString(),
                    etCorreo.text.toString()
                )
                Log.e("Registro", solRegistro.toString())
                var service = retrofit.create(InterCleanRoute::class.java)
                var call = service.getRegister(solRegistro)
                call.enqueue(object : Callback<RespuestaRegister> {
                    override fun onFailure(call: Call<RespuestaRegister>?, t: Throwable?) {
                        Log.e("Error", t?.message)
                    }

                    override fun onResponse(
                        call: Call<RespuestaRegister>?,
                        response: Response<RespuestaRegister>?
                    ) {
                        if (response!!.isSuccessful and  response!!.body().status) {
                            Toast.makeText(this@RegisterActivity,response.body().msg, Toast.LENGTH_LONG)
                            startActivity(Intent(this@RegisterActivity,LoginActivity::class.java))
                        } else {
                            Toast.makeText(this@RegisterActivity,response.body().msg, Toast.LENGTH_LONG)
                        }

                    }

                })
            }
        }


    }


}


