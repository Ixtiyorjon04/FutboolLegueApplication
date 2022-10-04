package uz.gita.futboollegueapplication.data.model

import androidx.room.*

@Entity(tableName = "Data")
data class SeasonData(
    val abbreviation: String,
    @PrimaryKey
    val name: String,
    val season: Int,
    val seasonDisplay: String,
    val standings: List<Standing>
)