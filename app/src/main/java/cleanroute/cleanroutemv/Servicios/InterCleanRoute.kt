package cleanroute.cleanroutemv.Servicios

import cleanroute.cleanroutemv.Modelos.*
import retrofit2.Call
import retrofit2.http.*

interface InterCleanRoute {

    @POST("Usuarios/Login")
    fun getLogin(@Body solLogin:SolicitudLogin): Call<RespuestaLogin>

    @POST("Usuarios")
    fun getRegister(@Body solRegistro: SolicitudRegister): Call<RespuestaRegister>

    @Headers("Content-Type: application/json")
    @GET("contenedores/Municipio/1234567M")
    fun getContenedores(): Call<Respuestas>

    @Headers("Content-Type: application/json")
    @GET("recicladoras")
    fun getRecicladoras(): Call<RespuestasRecicladora>

    @Headers("Content-Type: application/json")
    @POST("reportes")
    fun getReportes(@Body solReportes:SolicitudReportes): Call<RespuestaReportes>

}