package pe.edu.cibertec.appgrupo10

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import pe.edu.cibertec.appgrupo10.databinding.ActivityPregunta6Binding

class Pregunta6Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta6Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPregunta6Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        val km = binding.txtKilometros.text.toString().toDoubleOrNull()

        if (km == null) {
            binding.txtResultado.text =
                "Ingrese los kilómetros recorridos."
            return
        }

        if (km <= 200) {

            binding.txtResultado.text =
                "Recorrido cubierto por la tarifa contratada."

        } else {

            val kmExtra = km - 200
            val cobroTotal = 50.00 + (kmExtra * 1.20)

            binding.txtResultado.text =
                "Kilómetros registrados: $km\n" +
                        "Kilómetros extra: $kmExtra\n" +
                        "Total a pagar por kilometraje excedente: S/ %.2f".format(cobroTotal)
        }
    }
}