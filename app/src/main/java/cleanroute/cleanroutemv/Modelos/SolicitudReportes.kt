package cleanroute.cleanroutemv.Modelos

class SolicitudReportes(
    var MunicipioID: String,
    var Latitud: Double,
    var Longitud: Double,
    var Tipo: String
)
{
    override fun toString(): String {
        return "Reportes(MunicipioID='$MunicipioID', Latitud=$Latitud, Longitud=$Longitud, Tipo='$Tipo')"
    }
}