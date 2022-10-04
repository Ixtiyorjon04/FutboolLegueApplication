package uz.gita.futboollegueapplication.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Standing(
    val stats: List<Stat>,
    val team: Team
)