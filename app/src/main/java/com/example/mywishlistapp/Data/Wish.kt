package com.example.mywishlistapp.Data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wish-table")
data class Wish(
    @PrimaryKey(autoGenerate = true)
    val id:Long=0L,
    @ColumnInfo(name = "wish-title")
    val title:String="",
    @ColumnInfo(name = "wish-desc")
    val description:String=""
)

object DummyWish{
    val wishList=listOf(
        Wish(title = "Masuk Kerja di BUMN", description = "Lolos RBB jadi Kartap BUMN"),
        Wish(title = "Jadi Developer Android", description = "Jadi Developer Android di PGD Pusat"),
        Wish(title = "Kuliah S2 Luar Negeri", description = "Lolos Pendanaan LPDP S2 di Manchester")

    )
}
