package pe.edu.newhorizons.agenda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var contacts: List<Contact>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun onResume() {
        super.onResume()
        loadContacts()
        loadView()
    }

    fun loadView() {
        rvContact.adapter = ContactAdapter(contacts, this)
        rvContact.layoutManager = LinearLayoutManager(this)
    }

    fun loadContacts() {

        //val dbAdapter = DBAdapter(this)
        //contacts = dbAdapter.getContacts()

        contacts = AppDatabase.getInstance(this).getDao().getAllContacts()
        rvContact.adapter?.notifyDataSetChanged()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent(this, ContactActivity::class.java)
        startActivity(intent)
        return super.onOptionsItemSelected(item)
    }
}
