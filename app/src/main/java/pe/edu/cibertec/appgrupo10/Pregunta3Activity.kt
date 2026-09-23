package pe.edu.cibertec.appgrupo10

import android.os.Bundle
import android.view.View
import android.widget.Toast
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

    override fun onClick(view: View?) {

        if (view?.id == binding.btnCalcular.id) {

            val minutosTexto = binding.etMinutos.text.toString()

            if (minutosTexto.isEmpty()) {
                Toast.makeText(
                    this,
                    "Ingrese los minutos de retraso.",
                    Toast.LENGTH_SHORT
                ).show()
                return
            }

            val minutos = minutosTexto.toInt()

            if (minutos <= 15) {

                binding.tvResultado.text =
                    "Entrega dentro de la tolerancia operativa."

            } else {

                val exceso = minutos - 15
                val penalidad = 15.00 + (exceso * 2.50)

                binding.tvResultado.text =
                    "Minutos reportados: $minutos min\n" +
                            "Minutos de exceso: $exceso min\n" +
                            "Monto total de la penalidad: S/ %.2f".format(penalidad)
            }
        }
    }
}