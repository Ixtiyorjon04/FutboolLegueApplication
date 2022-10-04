package uz.gita.futboollegueapplication.domain.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.gita.futboollegueapplication.data.model.LeagueData
import uz.gita.futboollegueapplication.data.model.ResponseData
import uz.gita.futboollegueapplication.data.model.SeasonData
import uz.gita.futboollegueapplication.retrofit.ApiClient
import uz.gita.futboollegueapplication.retrofit.api.LeagueApi
import uz.gita.futboollegueapplication.room.database.LeagueDataBase
import uz.gita.futboollegueapplication.hasConnection

class LeagueRepositoryImpl : LeagueRepository {


    private val leagueApi = ApiClient.retrofit.create(LeagueApi::class.java)

    private val db = LeagueDataBase.getInstance().getLeagueDao()

    override val messageLiveData: MutableLiveData<String> = MutableLiveData()

    override fun getAllLeague(): LiveData<List<LeagueData>> {
        return db.getAllLeague()
    }

    override fun getAllLeagueByYear(c: String, d: Int, name: String): LiveData<SeasonData>? {
        TODO("Not yet implemented")
    }


    override fun fetch() {
        if (hasConnection()) {
            leagueApi.getAllData().enqueue(object : Callback<ResponseData<List<LeagueData>>> {
                override fun onResponse(
                    call: Call<ResponseData<List<LeagueData>>>,
                    response: Response<ResponseData<List<LeagueData>>>,
                ) {
                    if (response.isSuccessful) {
                        if (response.body() != null) {
                            val data = response.body()!!
                            db.updateAllLeague(data.data)
                        }
                    }
                }

                override fun onFailure(call: Call<ResponseData<List<LeagueData>>>, t: Throwable) {
                    messageLiveData.value = t.message
                }
            })
        } else {
            messageLiveData.value = "no internet connection"
        }
    }

    init {
        fetch()
    }
}