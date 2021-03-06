package pe.edu.newhorizons.recyclerview.ui

import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import pe.edu.newhorizons.recyclerview.R
import pe.edu.newhorizons.recyclerview.models.Country

class MainActivity : AppCompatActivity() {

    var countries = ArrayList<Country>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadCountries()

        rvCountry.adapter = CountryAdapter(countries, this)
        rvCountry.layoutManager = GridLayoutManager(this,3,RecyclerView.HORIZONTAL,false)
            //LinearLayoutManager(this)

    }

    fun loadCountries() {
        countries.add(Country("Perú"))
        countries.add(Country("México"))
        countries.add(Country("Chile"))
        countries.add(Country("Colombia"))
    }
}
