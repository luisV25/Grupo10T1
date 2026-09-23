package pe.edu.cibertec.appgrupo10

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pe.edu.cibertec.appgrupo10.databinding.ActivityPregunta1Binding

class   Activity_Pregunta1 : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPregunta1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnAceptar.setOnClickListener(this)
    }

    private fun calcularLongitud() {

        val longitud = binding.txLongitud.text.toString().toDoubleOrNull()

        if (longitud == null) {
            binding.lbResultado.text = "Ingrese una longitud válida."
            return
        }

        if (longitud <= 12) {

            binding.lbResultado.text = "Carga dentro de las dimensiones permitidas."

        } else {

            val exceso = longitud - 12
            val sobrecargo = 400 + (exceso * 120)

            binding.lbResultado.text = """
            Longitud ingresada: %.2f m
            Exceso de metros: %.2f m
            Sobrecargo total: S/ %.2f
        """.trimIndent().format(longitud, exceso, sobrecargo)
        }
    }

    override fun onClick(p0: View) {
       when(p0.id){
           R.id.btnAceptar -> calcularLongitud()
       }
    }
}
