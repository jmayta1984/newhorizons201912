package pe.edu.newhorizons.agenda

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact")
class Contact (
    @PrimaryKey(autoGenerate = true)
    var id: Int?,

    @ColumnInfo(name = "name")
    var name: String?,

    @ColumnInfo(name = "telephone")
    var telephone: String?


)
