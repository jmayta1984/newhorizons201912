package pe.edu.newhorizons.agenda

import androidx.room.*

@Dao
interface ContactDAO {

    @Query("select * from contact")
    fun getAllContacts(): List<Contact>

    @Query("select * from contact where id= :id")
    fun getContactById(id: Int): Contact

    @Insert
    fun insertContacts(vararg contacts: Contact)

    @Delete
    fun deleteContacts(vararg contacts: Contact)

    @Update
    fun updateContacts(vararg contacts: Contact)
}