package pe.edu.cibertec.appgrupo10

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import pe.edu.cibertec.appgrupo10.databinding.ActivityPregunta5Binding

class Pregunta5Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta5Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPregunta5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        val peso = binding.txtPeso.text.toString().toDoubleOrNull()

        if (peso == null) {
            binding.txtResultado.text =
                "Ingrese el peso del camión."
            return
        }

        if (peso <= 18) {

            binding.txtResultado.text =
                "Vehículo con carga reglamentaria autorizada."

        } else {

            val exceso = peso - 18
            val multa = 1800 + (exceso * 650)

            binding.txtResultado.text =
                "Peso registrado: %.2f toneladas\n".format(peso) +
                        "Exceso de carga: %.2f toneladas\n".format(exceso) +
                        "Multa calculada: S/ %.2f".format(multa)
        }
    }
}