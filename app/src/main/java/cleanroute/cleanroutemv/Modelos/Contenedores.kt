package cleanroute.cleanroutemv.Modelos

class Contenedores(
    var ContenedorID: String,
    var Tipo: String,
    var Capacidad: String,
    var Tamano: String,
    var Latitud: Double,
    var Longitud: Double,
    var MunicipioID: String
)
{
    override fun toString(): String {
        return "Contenedores(ContenedorID='$ContenedorID', Tipo='$Tipo', Capacidad='$Capacidad', Tamano='$Tamano', Latitud=$Latitud, Longitud=$Longitud, MunicipioID='$MunicipioID')"
    }
}