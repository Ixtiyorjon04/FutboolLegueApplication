package uz.gita.futboollegueapplication.room.dao

import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import uz.gita.futboollegueapplication.data.model.SeasonData

interface BaseDao<T> {
    @Insert
    fun insert(list : List<T>)

    @Query("delete from LeagueData")
    fun delete()

    @Insert
    fun insertseason(list : SeasonData)

    @Query("delete from Data")
    fun deleteseason()

}