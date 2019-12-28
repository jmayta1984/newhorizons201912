package pe.edu.newhorizons.geoquiz.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import pe.edu.newhorizons.geoquiz.R
import pe.edu.newhorizons.geoquiz.models.Question

class MainActivity : AppCompatActivity() {

    val questions = ArrayList<Question>()
    var actualPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadQuestions()
        loadViews()

        btYes.setOnClickListener {
            verifyAnswer(true)
        }

        btNo.setOnClickListener {
            verifyAnswer(false)
        }


        btNext.setOnClickListener {
            actualPosition = (actualPosition + 1) % questions.size
            loadViews()
        }

    }

    fun verifyAnswer(answer: Boolean) {

        if (answer == questions[actualPosition].answer)
            Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show()
    }


    fun loadViews() {
        tvStatement.text = questions[actualPosition].statement
    }

    fun loadQuestions() {

        questions.add(Question("Es Lima la capital de Ecuadro", false))
        questions.add(Question("Quito es una ciudad de Chile", false));
        questions.add(Question("Santiago es la capital de Chile", true))

    }
}
