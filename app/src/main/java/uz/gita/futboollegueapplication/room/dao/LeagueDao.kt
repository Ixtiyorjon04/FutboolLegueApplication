package uz.gita.futboollegueapplication.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import uz.gita.futboollegueapplication.data.model.LeagueData
import uz.gita.futboollegueapplication.data.model.SeasonData

@Dao
interface LeagueDao : BaseDao<LeagueData> {

    @Query("select * from LeagueData")
    fun getAllLeague(): LiveData<List<LeagueData>>

    @Transaction
    fun updateAllLeague(list: List<LeagueData>) {

    }

    @Query("SELECT * FROM Data WHERE name=:name AND season=:year")
    fun getAllSeason(name: String, year: Int): LiveData<SeasonData>

    @Transaction
    fun updateAllSeason(list: SeasonData) {

    }
}