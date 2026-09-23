package pe.edu.cibertec.pregunta4activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pe.edu.cibertec.pregunta4activity.databinding.ActivityPregunta4Binding
import java.util.Locale

class Pregunta4Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta4Binding

    companion object {
        const val LIMITE_HORAS_GRATIS = 48.0
        const val TARIFA_BASE = 90.0
        const val COSTO_POR_HORA_EXCEDENTE = 12.0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityPregunta4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.btnCalcular.id -> calcularAlmacenaje()
        }
    }

    private fun calcularAlmacenaje() {
        val textoHoras = binding.etHoras.text.toString()

        if (textoHoras.isBlank()) {
            Toast.makeText(this, "Ingresa las horas de bodegaje", Toast.LENGTH_SHORT).show()
            return
        }

        val horas = textoHoras.toDoubleOrNull()
        if (horas == null || horas < 0) {
            Toast.makeText(this, "Ingresa un número válido de horas", Toast.LENGTH_SHORT).show()
            return
        }

        if (horas <= LIMITE_HORAS_GRATIS) {
            binding.tvResultado.text = "Almacenamiento cubierto por la tarifa base."
        } else {
            val exceso = horas - LIMITE_HORAS_GRATIS
            val cargo = TARIFA_BASE + (COSTO_POR_HORA_EXCEDENTE * exceso)

            val cargoFormateado = String.format(Locale("es", "PE"), "S/ %.2f", cargo)

            binding.tvResultado.text = buildString {
                append("Horas de permanencia: ${formatearHoras(horas)}\n")
                append("Exceso de tiempo: ${formatearHoras(exceso)} horas\n")
                append("Cargo por estadía prolongada: $cargoFormateado")
            }
        }
    }

    private fun formatearHoras(valor: Double): String {
        return if (valor == valor.toLong().toDouble()) {
            valor.toLong().toString()
        } else {
            String.format(Locale("es", "PE"), "%.2f", valor)
        }
    }
}