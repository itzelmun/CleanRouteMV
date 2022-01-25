package cleanroute.cleanroutemv.Modelos

import java.util.*

class Recicladoras (
    var RecicladoraID: String,
    var Tipo: String,
    var Nombre: String,
    var Domicilio: String,
    var Telefono: String,
    var Horarios: String,
    var Dias: String,
    var Encargado: String,
    var Latitud: Double,
    var Longitud: Double
)
{
    override fun toString(): String {
        return "Recicladoras(RecicladoraID='$RecicladoraID', Tipo='$Tipo', Nombre='$Nombre', Domicilio='$Domicilio', Telefono=$Telefono, Horarios='$Horarios', Dias='$Dias', Encargado='$Encargado', Latitud=$Latitud, Longitud=$Longitud)"
    }
}