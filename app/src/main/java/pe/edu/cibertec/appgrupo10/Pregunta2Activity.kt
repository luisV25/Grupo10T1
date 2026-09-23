package pe.edu.cibertec.appgrupo10

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import pe.edu.cibertec.appgrupo10.databinding.ActivityPregunta2Binding

class Pregunta2Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPregunta2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        val dias = binding.txtDias.text.toString().toIntOrNull()

        if (dias == null) {
            binding.txtResultado.text =
                "Ingrese los días transcurridos."
            return
        }

        if (dias <= 7) {

            binding.txtResultado.text =
                "Contenedor retornado dentro de los días libres."

        } else {

            val mora = dias - 7
            val monto = 200 + (mora * 75)

            binding.txtResultado.text =
                "Días totales transcurridos: $dias\n" +
                        "Días de mora: $mora\n" +
                        "Monto de demurrage liquidado: S/ %.2f".format(monto.toDouble())
        }
    }
}