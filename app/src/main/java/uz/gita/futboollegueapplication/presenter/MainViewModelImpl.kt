package uz.gita.futboollegueapplication.presenter

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.futboollegueapplication.data.TableDataWrapperSeason
import uz.gita.futboollegueapplication.data.model.TableDataWrapper
import uz.gita.futboollegueapplication.data.model.tableview.ColumnHeader
import uz.gita.futboollegueapplication.data.model.tableview.ImageCell
import uz.gita.futboollegueapplication.data.model.tableview.RowHeader
import uz.gita.futboollegueapplication.data.model.tableview.TextCell
import uz.gita.futboollegueapplication.domain.repository.LeagueRepositoryImpl
import uz.gita.futboollegueapplication.hasConnection

class MainViewModelImpl : ViewModel(), MainViewModel {
    val repository = LeagueRepositoryImpl()

    override val messageLiveData: MutableLiveData<String> = repository.messageLiveData


    override val leagueListLiveData: MediatorLiveData<TableDataWrapper> = MediatorLiveData()
    override val seasonListLiveData = MutableLiveData<TableDataWrapperSeason>()


    override fun season(id: String, year: Int, name: String) {
        leagueListLiveData.addSource(repository.getAllLeagueByYear(id, year, name)!!) { its ->
            if (its != null) {
                val rowHeader = (1..its.standings.size).map {
                    RowHeader(it.toString())
                }.toList()
                val columnHeader =
                    listOf(
                        "legue name",
                        "logo",
                        "year",
                        "location",
                        "name",
                        "abbreviation",
                        "displayValue",
                        "description",
                        "type"
                    ).map { ColumnHeader(it) }
                var counter = 0
                val cellList = its.standings.map {

                    listOf(
                        TextCell(its.name),
                        ImageCell(if(it.team.logos[0].href!=null){
                            it.team.logos[0].href
                        }else{ it.team.logos[1].href}),
                        TextCell(its.season.toString()),
                        TextCell(it.team.location),
                        TextCell(it.team.name),
                        TextCell(it.team.abbreviation),
                        TextCell(
                            it.stats[if (counter < it.stats.size) {
                                counter
                            } else {
                                counter
                            }].type
                        ),
                                TextCell (
                                it.stats[if (counter < it.stats.size) {
                                    counter
                                } else {
                                    counter
                                }].displayValue
                                ),
                        TextCell(
                            it.stats[if (counter < it.stats.size - 1) {
                                counter++
                            } else {
                                counter
                            }].description
                        )
                    )
                }
                val tableDataWrapper = TableDataWrapperSeason(rowHeader, columnHeader, cellList)
                seasonListLiveData.value = tableDataWrapper
            } else {
                if (!hasConnection()) {
                    messageLiveData.value = "not saved data"
                }
            }
        }
    }

    override fun getAll() {
        leagueListLiveData.addSource(repository.getAllLeague()) {
            val rowHeaders = (1..it.size).map { RowHeader(it.toString()) }.toList()
            val columnHeaders =
                listOf("logo", "name", "slug", "abbr").map { ColumnHeader(it) }
            val id = it.map {
                TextCell(it.id)
            }
            val cellList = it.map {
                listOf(
                    ImageCell(it.Ccy),
                    TextCell(it.CcyNm_RU),
                    TextCell(it.CcyNm_UZ),
                    TextCell(it.Diff)
                )
            }
            val tableDataWrapper = TableDataWrapper(rowHeaders, columnHeaders, cellList, id)
            leagueListLiveData.value = tableDataWrapper
        }
    }

    init {
        repository.fetch()
        leagueListLiveData.addSource(repository.getAllLeague()) {
            val rowHeaders = (1..it.size).map { RowHeader(it.toString()) }.toList()
            val columnHeaders =
                listOf("logo", "name", "slug", "abbr").map { ColumnHeader(it) }
            val id = it.map {
                TextCell(it.id)
            }
            val cellList = it.map {
                listOf(
                    ImageCell(it.Ccy),
                    TextCell(it.CcyNm_RU),
                    TextCell(it.CcyNm_UZ),
                    TextCell(it.Diff)
                )
            }
            val tableDataWrapper = TableDataWrapper(rowHeaders, columnHeaders, cellList, id)
            leagueListLiveData.value = tableDataWrapper
        }
    }
}