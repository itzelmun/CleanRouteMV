package cleanroute.cleanroutemv.Modelos

import com.google.gson.annotations.SerializedName

class RespuestaLogin(
    var status: Boolean,
    var MunicipioID: String
)
{
    override fun toString(): String {
        return "RespuestaLogin(Status=$status, MunicipioID='$MunicipioID')"
    }
}