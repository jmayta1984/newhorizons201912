package pe.edu.newhorizons.dialogs

import android.app.TimePickerDialog
import android.content.DialogInterface
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var progressBarStatus = 0
    var rate = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btSave.setOnClickListener {
            val saveAlert = AlertDialog.Builder(this)
            saveAlert.setTitle("Save")
            saveAlert.setMessage("Are you sure you want to save changes?")
            saveAlert.setPositiveButton("Yes") { dialog: DialogInterface, i: Int ->
                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
            }
            saveAlert.setNegativeButton("No") { dialog: DialogInterface, i: Int ->
                Toast.makeText(this, "Not saved", Toast.LENGTH_SHORT).show()
            }
            saveAlert.show()
        }

        btDownload.setOnClickListener {
            Thread(Runnable {
                while (progressBarStatus < 100) {
                    try {
                        rate += 10
                        Thread.sleep(1000)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                    progressBarStatus = rate
                    pbDownload.progress = progressBarStatus
                }
                pbDownload.visibility = ProgressBar.INVISIBLE
            }).start()
        }

        sbResult.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tvResult.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                tvResult.text = "Tracking started ${sbResult.progress}"

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                tvResult.text = "Thank you for selecting ${sbResult.progress}"

            }


        })

        btDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val month = calendar.get(Calendar.MONTH)
            val year = calendar.get(Calendar.YEAR)
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minutes = calendar.get(Calendar.MINUTE)

            val timeDialog = TimePickerDialog(
                this,
                TimePickerDialog.OnTimeSetListener
                { timePicker, hourOfDay, minute ->
                    tvResult.text = "$hourOfDay:$minute"
                }, hour, minutes, true

            )
            timeDialog.show()

/*
            val dateDialog = DatePickerDialog(
                this,
                android.R.style.ThemeOverlay,
                DatePickerDialog.OnDateSetListener
                { DatePicker, year, month, day ->
                    tvResult.text = "$day/${month + 1}/$year"
                }, year, month, day
            )
            dateDialog.show()*/

        }

        btSnack.setOnClickListener {
            val snackBar = Snackbar.make(
                findViewById(R.id.clMain),
                "No internet connection!!", Snackbar.LENGTH_LONG
            )

            snackBar.setAction("Retry") {            }
            snackBar.setActionTextColor(Color.RED)
            snackBar.show()

        }
    }
}
