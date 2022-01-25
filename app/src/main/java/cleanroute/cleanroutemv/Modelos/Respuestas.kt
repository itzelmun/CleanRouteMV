package cleanroute.cleanroutemv.Modelos

import java.sql.ClientInfoStatus

class Respuestas(
    var status: Boolean,
    var data : List<Contenedores>
) {
    override fun toString(): String {
        return "Respuestas(status=$status, data=$data)"
    }
}

