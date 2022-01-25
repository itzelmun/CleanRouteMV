package cleanroute.cleanroutemv.Modelos

class SolicitudLogin(
    var Correo: String,
    var Clave: String
){
    override fun toString(): String {
        return "SolicitudLogin(Correo='$Correo', Clave='$Clave')"
    }
}