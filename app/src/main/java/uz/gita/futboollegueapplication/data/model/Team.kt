package uz.gita.futboollegueapplication.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Team(
    val id:Int,
    val name:String,
    val abbreviation: String,
    val isActive: Boolean,
    val location: String,
    @Embedded
    val logos: List<Logo>,
)