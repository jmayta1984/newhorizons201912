package pe.edu.newhorizons.layouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun display(view: View) {
        tvInfo.text =
            "Android Appication Development, Android Security Essentials and Monetize Android Applications"
    }
}
