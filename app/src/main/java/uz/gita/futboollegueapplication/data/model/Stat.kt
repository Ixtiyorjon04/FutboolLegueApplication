package uz.gita.futboollegueapplication.data.model

import androidx.room.Entity

data class Stat(
    val type:String,
    val description: String,
    val displayValue: String,
    val shortDisplayName: String
)