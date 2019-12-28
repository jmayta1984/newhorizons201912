package pe.edu.newhorizons.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btSecondActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)

            val name = etName.text.toString()

            intent.putExtra("keyName",name)

            startActivity(intent)
        }
    }
}
