package pe.edu.newhorizons.androidstorage

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val PREF_NAME = "myPrefs"
    lateinit var myPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myPref = getSharedPreferences(PREF_NAME, 0)

        loadData()

        btSave.setOnClickListener {

            var editor = myPref.edit()

            if (!TextUtils.isEmpty(etName.text.toString())) {
                editor.putString("keyName", etName.text.toString())
                editor.commit()
            } else {
                Toast.makeText(
                    this, "Por favor ingrese su nombre",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }


    }

    fun loadData() {

        if (myPref.contains("keyName")) {
            tvName.text = myPref.getString("keyName", "no encontrado")
        }
    }
}
