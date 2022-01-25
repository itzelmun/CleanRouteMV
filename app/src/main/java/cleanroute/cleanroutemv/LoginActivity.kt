package cleanroute.cleanroutemv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import cleanroute.cleanroutemv.Modelos.RespuestaLogin
import cleanroute.cleanroutemv.Modelos.SolicitudLogin
import cleanroute.cleanroutemv.Servicios.ApiUrlCleanRoute
import cleanroute.cleanroutemv.Servicios.InterCleanRoute
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginActivity : AppCompatActivity() {
    lateinit var etCorreo: EditText
    lateinit var etClave: EditText
    var gson: Gson? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        gson = GsonBuilder().setLenient().create()

        val retrofit = Retrofit.Builder()
            .baseUrl(ApiUrlCleanRoute.BaseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        etCorreo = findViewById(R.id.etCorreo)
        etClave = findViewById(R.id.etClave)

        var bEntrar = findViewById(R.id.bEntrar) as Button
        bEntrar.setOnClickListener{

            var usuario = SolicitudLogin(etCorreo.text.toString(), etClave.text.toString())
            var service = retrofit.create(InterCleanRoute::class.java)
            var call = service.getLogin(usuario)
            call.enqueue(object : Callback<RespuestaLogin>{
                override fun onFailure(call: Call<RespuestaLogin>?, t: Throwable?) {
                    Log.e("Conexion con", t?.message)
                }

                override fun onResponse(
                    call: Call<RespuestaLogin>?,
                    response: Response<RespuestaLogin>?
                ) {

                    if(response?.isSuccessful!!) {
                        val Respuesta =response.body()
                        if (Respuesta.status){
                            startActivity(Intent(this@LoginActivity,MainActivity::class.java))
                        } else {
                            // poner un mensaje
                            Toast.makeText(this@LoginActivity,"EL correo o tu contraseña es incorrecto",Toast.LENGTH_LONG)

                        }

                    }

                }

            })

        }
        var bRegistrar = findViewById(R.id.bRegistroLogin) as Button
        bRegistrar.setOnClickListener{
            startActivity(Intent(this@LoginActivity,RegisterActivity::class.java))
        }
    }
}
