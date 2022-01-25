package cleanroute.cleanroutemv.Modelos

class RespuestasRecicladora(
    var status: Boolean,
    var data : List<Recicladoras>
) {
    override fun toString(): String {
        return "Respuestas(status=$status, data=$data)"
    }
}