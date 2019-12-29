package pe.edu.newhorizons.agenda

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_contact.view.*

class ContactAdapter(val contacts: ArrayList<Contact>, val context: Context) :
    RecyclerView.Adapter<ItemContact>() {

    // Crea la vista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemContact {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.item_contact, parent, false)
        return ItemContact(view)
    }

    // Devuelve la cantidad de elementos
    override fun getItemCount(): Int {
        return contacts.size
    }

    // Pinta la información
    override fun onBindViewHolder(item: ItemContact, position: Int) {
        item.bindItem(contacts.get(position))
    }

}

class ItemContact(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindItem(contact: Contact) {
        itemView.tvName.text = contact.name
        itemView.tvPhone.text = contact.telephone
    }

}
