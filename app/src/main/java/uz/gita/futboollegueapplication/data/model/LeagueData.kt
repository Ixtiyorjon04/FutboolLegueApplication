package uz.gita.futboollegueapplication.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class LeagueData(
    val Ccy: String,
    val CcyNm_EN: String,
    val CcyNm_RU: String,
    val CcyNm_UZ: String,
    val CcyNm_UZC: String,
    val Code: String,
    val Date: String,
    val Diff: String,
    val Nominal: String,
    val Rate: String,
    @PrimaryKey
    val id: String
//    @PrimaryKey
//    val id: String,
//    val name: String,
//    val slug: String,
//    val abbr: String,
//
//    @Embedded
//    val logos: LogoData,
)
