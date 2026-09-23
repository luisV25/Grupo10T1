package pe.edu.cibertec.appgrupo10

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import pe.edu.cibertec.appgrupo10.databinding.ActivityPregunta3Binding

class Pregunta3Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPregunta3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        val minutos = binding.txtMinutos.text.toString().toIntOrNull()

        if (minutos == null) {
            binding.txtResultado.text =
                "Ingrese los minutos de retraso."
            return
        }

        if (minutos <= 15) {

            binding.txtResultado.text =
                "Entrega dentro de la tolerancia operativa."

        } else {

            val exceso = minutos - 15
            val penalidad = 15 + (exceso * 2.50)

            binding.txtResultado.text =
                "Minutos reportados: $minutos\n" +
                        "Minutos de exceso: $exceso\n" +
                        "Monto total de la penalidad: S/ %.2f".format(penalidad)
        }
    }
}