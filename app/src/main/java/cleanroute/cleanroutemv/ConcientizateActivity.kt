package cleanroute.cleanroutemv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class ConcientizateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_concientizate2)

        var mAlertDialogBtn1 = findViewById<Button>(R.id.btnShowAlertDialog1)
        mAlertDialogBtn1.setOnClickListener {

            var mAlertDialog = AlertDialog.Builder(this@ConcientizateActivity)
            mAlertDialog.setTitle ("Nueva ley de residuos plásticos en CDMX") //Dialogo de la alert
            mAlertDialog.setMessage("La Asociación Nacional de Industrias del Plástico (ANIPAC) dijo este viernes que la ley de residuos sólidos de la capital, la cual prohibirá a partir del 2020 el uso de plásticos de un solo uso (como las bolsas y las cápsulas de café), dañará la economía de la Ciudad de México.")
            mAlertDialog.setIcon(R.mipmap.foco); //icono de la alert
            //agregar boton positivo a la alert
            mAlertDialog.setPositiveButton("Volver") { dialog, id ->
            }
            mAlertDialog.show()// muestra la alert
    }
        var mAlertDialogBtn2 = findViewById<Button>(R.id.btnShowAlertDialog2)
        mAlertDialogBtn2.setOnClickListener {

            var mAlertDialog = AlertDialog.Builder(this@ConcientizateActivity)
            mAlertDialog.setTitle("Problemas de la basura") //Dialogo de la alert
            mAlertDialog.setMessage("De acuerdo con un informe publicado en Nature journal, el problema de la basura o los desechos sólidos está asumiendo proporciones terribles en la actualidad. Para fines de este siglo (2100), la basura se recolectará a razón de 11 millones de toneladas por día en todo el mundo, más de tres veces la tasa actual.")
            mAlertDialog.setIcon(R.mipmap.foco); //icono de la alert
            //agregar boton positivo a la alert
            mAlertDialog.setPositiveButton("Volver") { dialog, id ->
            }
            mAlertDialog.show()// muestra la alert
}

        var mAlertDialogBtn3 = findViewById<Button>(R.id.btnShowAlertDialog3)
        mAlertDialogBtn3.setOnClickListener {

            var mAlertDialog = AlertDialog.Builder(this@ConcientizateActivity)
            mAlertDialog.setTitle("La separación de basura en la Ciudad de México va a la baja") //Dialogo de la alert
            mAlertDialog.setMessage("La selección de residuos orgánicos ha caído más de la mitad comparando 2017 y 2019.  La caída en la separación de residuos sólidos se debe a que los habitantes de la urbe están seleccionando menos la basura Y a ello se suma que los trabajadores que la recolectan en camiones y la entregan en Estaciones de Transferencia están dejando de pedir los desechos separados.\n" +
                    "Además, no se están respetando los días de entrega de residuos.\n" +
                    "La baja en la separación de residuos no sólo es un problema medio ambiental que reduce la posibilidad del reuso y reciclaje, es también un problema económico para las arcas de la Ciudad de México, pues entre más basura lleves a rellenos sanitarios, más dinero debes pagar por transporte y depósito.\n" +
                    "El problema de la no separación en fuente afecta a la economía de la Ciudad de México porque el gasto de transporte y disposición final en rellenos cuesta dinero, mientras más dispongas en rellenos más dinero vas a pagar”\n")
            mAlertDialog.setIcon(R.mipmap.foco); //icono de la alert
            //agregar boton positivo a la alert
            mAlertDialog.setPositiveButton("Volver") { dialog, id ->
            }
            mAlertDialog.show()// muestra la alert

    }
        var mAlertDialogBtn4 = findViewById<Button>(R.id.btnShowAlertDialog4)
        mAlertDialogBtn4.setOnClickListener {

            var mAlertDialog = AlertDialog.Builder(this@ConcientizateActivity)
            mAlertDialog.setTitle("RESIDUOS PELIGROSOS EN MÉXICO") //Dialogo de la alert
            mAlertDialog.setMessage("En México más del 90% de los residuos peligrosos que se producen al año se manejan inadecuadamente.\n" +
                    "Como puede advertirse, en México los residuos peligrosos no controlados se encuentran al alcance de la población; este hecho, más que una problemática de contaminación ambiental, constituye un severo riesgo para la salud pública.\n")
            mAlertDialog.setIcon(R.mipmap.foco); //icono de la alert
            //agregar boton positivo a la alert
            mAlertDialog.setPositiveButton("Volver") { dialog, id ->
            }
            mAlertDialog.show()// muestra la alert

}
        var mAlertDialogBtn5 = findViewById<Button>(R.id.btnShowAlertDialog5)
        mAlertDialogBtn5.setOnClickListener {

            var mAlertDialog = AlertDialog.Builder(this@ConcientizateActivity)
            mAlertDialog.setTitle("¿Qué hay que hacer para reciclar un plástico?") //Dialogo de la alert
            mAlertDialog.setMessage("Todos los que van marcados con el código RIC son aprovechables en el proceso de reciclado.\n" +
                    "Por tanto, se pueden reciclar los envases y envoltorios de plástico, como las botellas, los vasos, los platos, las bandejas, las garrafas, los tapones, etcétera.\n" +
                    "Es muy posible que la botella que tires en el contenedor amarillo acabe siendo otra botella nueva.\n")
            mAlertDialog.setIcon(R.mipmap.foco); //icono de la alert
            //agregar boton positivo a la alert
            mAlertDialog.setPositiveButton("Volver") { dialog, id ->
            }
            mAlertDialog.show()// muestra la alert

    }


        var mAlertDialogBtn6 = findViewById<Button>(R.id.btnShowAlertDialog6)
        mAlertDialogBtn6.setOnClickListener {

            var mAlertDialog = AlertDialog.Builder(this@ConcientizateActivity)
            mAlertDialog.setTitle("Qué plásticos no se reciclan") //Dialogo de la alert
            mAlertDialog.setMessage(
                "-\tLos plásticos mezclados con otros materiales: sea un plástico clasificado o no, cuando se trata de materiales difíciles de separar, como el pegamento, el aluminio de los blísters de medicamentos.\n" +
                        "-\tPlásticos hechos con otras resinas: si se trata de un objeto de resina, como algunos muebles de exterior, no se puede reciclar aunque lleve piezas o partes de plástico.\n" +
                        "-\tPlásticos degradados por el sol: estos materiales suelen resquebrajarse con apenas tocarlos, e incluso pueden cortar, pues el plástico se está descomponiendo. Por esto, no se pueden aprovechar al haber perdido sus propiedades para construir un nuevo objeto.\n" +
                        "-\tAlgunos plásticos pigmentados: hay ciertos colorantes que añaden en este material durante la fabricación de algunos objetos que modifican el propio plástico. El inconveniente es que estos colorantes al procesarse en las máquinas de reciclaje pueden convertir al plástico en hilos que dañan y atascan las máquinas.\n"
            )
            mAlertDialog.setIcon(R.mipmap.foco); //icono de la alert
            //agregar boton positivo a la alert
            mAlertDialog.setPositiveButton("Volver") { dialog, id ->
            }
            mAlertDialog.show()// muestra la alert

        }


}}
