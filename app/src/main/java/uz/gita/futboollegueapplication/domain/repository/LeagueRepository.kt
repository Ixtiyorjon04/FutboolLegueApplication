package uz.gita.futboollegueapplication.domain.repository

import androidx.lifecycle.LiveData
import uz.gita.futboollegueapplication.data.model.LeagueData
import uz.gita.futboollegueapplication.data.model.SeasonData

interface LeagueRepository {

    val messageLiveData: LiveData<String>

    fun getAllLeague(): LiveData<List<LeagueData>>
    fun getAllLeagueByYear(c: String, d: Int,name:String): LiveData<SeasonData>?

    fun fetch()

}