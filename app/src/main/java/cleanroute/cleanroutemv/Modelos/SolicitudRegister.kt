package cleanroute.cleanroutemv.Modelos

class SolicitudRegister (
    var MunicipioID: String,
    var Nombre: String,
    var Apellido: String,
    var Clave: String,
    var Correo: String
){
    override fun toString(): String {
        return "SolicitudRegister( MunicipioID='$MunicipioID',Correo='$Correo', Clave='$Clave', Apellido='$Apellido', Nombre='$Nombre')"
    }
}