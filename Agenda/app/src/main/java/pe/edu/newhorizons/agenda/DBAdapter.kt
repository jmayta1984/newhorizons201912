package pe.edu.newhorizons.agenda

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBAdapter( context: Context) {
    val dbHelper: DBHelper
    lateinit var sqliteDatabase: SQLiteDatabase

    init {
        dbHelper = DBHelper(context, "agenda", null, 1)
    }

    fun openDB() {
        sqliteDatabase = dbHelper?.writableDatabase
    }


    fun insertContact(contact: Contact) {
        val contentValues = ContentValues()
        contentValues.put("name", contact.name)
        contentValues.put("telephone", contact.telephone)
        openDB()
        sqliteDatabase.insert(
            "CONTACT",
            null, contentValues
        )

    }



    fun getContacts(): ArrayList<Contact> {

        openDB()
        val result_columns = arrayOf("id", "name", "telephone")
        var cursor = sqliteDatabase
            .query(
                true, "CONTACT", result_columns,
                null, null, null, null,
                null, null
            )

        val results = ArrayList<Contact>()

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(0)
                val name = cursor.getString(1)
                val telephone = cursor.getString(2)


                val contact = Contact(id, name, telephone)
                results.add(contact)

            } while (cursor.moveToNext())
        }
        cursor.close()
        return results
    }


    inner class DBHelper(
        context: Context?,
        name: String?,
        factory: SQLiteDatabase.CursorFactory?,
        version: Int
    ) : SQLiteOpenHelper(context, name, factory, version) {
        override fun onCreate(db: SQLiteDatabase?) {
            val query =
                "CREATE TABLE CONTACT(id integer primary key autoincrement, name text, telephone text)"
            db?.execSQL(query)
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            val query =
                "DROP TABLE IF EXISTS CONTACT;"
            db?.execSQL(query)
            onCreate(db)
        }

    }
}