package pe.edu.newhorizons.recyclerview.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.prototype_country.view.*
import pe.edu.newhorizons.recyclerview.R
import pe.edu.newhorizons.recyclerview.models.Country


class CountryAdapter(val countries: ArrayList<Country>, val context: Context) :
    RecyclerView.Adapter<CountryPrototype>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryPrototype {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.prototype_country, parent, false)
        return CountryPrototype(view)
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    override fun onBindViewHolder(holder: CountryPrototype, position: Int) {
        holder.bindItem(countries.get(position), context)
    }


}

class CountryPrototype(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindItem(country: Country, context: Context) {
        itemView.tvName.text = country.name

        itemView.setOnClickListener {
            Toast.makeText(
                context, "${country.name}"
                , Toast.LENGTH_LONG
            ).show()
        }
    }
}
