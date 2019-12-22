package pe.edu.newhorizons.geoquiz.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import pe.edu.newhorizons.geoquiz.R
import pe.edu.newhorizons.geoquiz.models.Question

class MainActivity : AppCompatActivity() {

    var questions = ArrayList<Question>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btTrue.setOnClickListener {
            Toast.makeText(this,"Incorrecto",Toast.LENGTH_SHORT).show()
        }

        btFalse.setOnClickListener {
            Toast.makeText(this,"Correcto",Toast.LENGTH_SHORT).show()

        }
    }
}
