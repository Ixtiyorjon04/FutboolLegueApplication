package uz.gita.futboollegueapplication.presenter

import androidx.lifecycle.LiveData
import uz.gita.futboollegueapplication.data.TableDataWrapperSeason
import uz.gita.futboollegueapplication.data.model.TableDataWrapper

interface MainViewModel {
    val messageLiveData : LiveData<String>

    val leagueListLiveData : LiveData<TableDataWrapper>
    val seasonListLiveData : LiveData<TableDataWrapperSeason>

    fun season(id:String,year:Int,name:String)

fun getAll()
}