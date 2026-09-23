package pe.edu.cibertec.appgrupo10

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPregunta7 = findViewById<Button>(R.id.btnPregunta7)

        btnPregunta7.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        if (v?.id == R.id.btnPregunta7) {
            val intent = Intent(this, Pregunta7Activity::class.java)
            startActivity(intent)
        }
    }
}