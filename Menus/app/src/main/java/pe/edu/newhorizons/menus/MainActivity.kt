package pe.edu.newhorizons.menus

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.webkit.WebViewClient
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btGo.setOnClickListener {
            wvMain.setBackgroundColor(Color.TRANSPARENT)

            wvMain.settings.javaScriptEnabled = true
            wvMain.settings.loadsImagesAutomatically = true

            wvMain.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
            wvMain.setWebViewClient( WebViewClient())

            wvMain.loadUrl(etUrl.text.toString())

        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.optionDevelopment ->
                Toast.makeText(
                    this,
                    "Development", Toast.LENGTH_SHORT
                ).show()
            R.id.optionSecurity ->
                Toast.makeText(
                    this,
                    "Secuirty Essentials", Toast.LENGTH_SHORT
                ).show()
            R.id.optionUI ->
                Toast.makeText(
                    this,
                    "UI/UX", Toast.LENGTH_SHORT
                ).show()


        }
        return super.onOptionsItemSelected(item)

    }
}