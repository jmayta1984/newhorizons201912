package pe.edu.newhorizons.androidstorage

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_internal.*
import java.io.FileOutputStream
import java.lang.Exception

class InternalActivity : AppCompatActivity() {

    val file = "hello_file"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internal)

        btSave.setOnClickListener {
            try {
                var fileOut: FileOutputStream = openFileOutput(file, Context.MODE_PRIVATE)
                fileOut.write(etName.text.toString().toByteArray(Charsets.UTF_8))
                fileOut.close()
                Toast.makeText(
                    this,
                    "Archivo guardado", Toast.LENGTH_SHORT
                ).show()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        btLoad.setOnClickListener {

            try {
                val fileInput = openFileInput(file)
                var temp = ""

                var bytes = fileInput.readBytes()

                for (byte in bytes) {
                    temp += byte.toChar()
                }

                tvName.text = temp
                Toast.makeText(
                    this,
                    "Archivo cargado", Toast.LENGTH_SHORT
                ).show()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
