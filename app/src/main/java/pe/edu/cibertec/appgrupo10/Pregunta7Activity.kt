package pe.edu.cibertec.appgrupo10

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import pe.edu.cibertec.appgrupo10.databinding.ActivityPregunta7Binding

class Pregunta7Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta7Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPregunta7Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        val minutos = binding.txtMinutos.text.toString().toIntOrNull()

        if (minutos == null) {
            binding.txtResultado.text =
                "Ingrese los minutos de permanencia."
            return
        }

        if (minutos <= 45) {

            binding.txtResultado.text =
                "Maniobra terminada dentro del tiempo asignado."

        } else {

            val exceso = minutos - 45
            val cargo = 70 + (exceso * 4)

            binding.txtResultado.text =
                "Minutos de uso: $minutos\n" +
                        "Exceso de permanencia: $exceso minutos\n" +
                        "Cargo por ocupación extraordinaria: S/ %.2f".format(cargo.toDouble())
        }
    }
}