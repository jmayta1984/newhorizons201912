package pe.edu.newhorizons.agenda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_contact.*

class ContactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.contact_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.optionSave -> {
                saveContact()
            }
            R.id.optionDelete -> {
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun saveContact() {

        val dbAdapter = DBAdapter(this)
        val contact = Contact(
            1,
            etName.text.toString(),
            etTelephone.text.toString()
        )

        dbAdapter.insertContact(contact)
        finish()
    }
}
