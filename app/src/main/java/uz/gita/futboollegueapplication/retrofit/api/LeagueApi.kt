package uz.gita.futboollegueapplication.retrofit.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import uz.gita.futboollegueapplication.data.model.SeasonData
import uz.gita.futboollegueapplication.data.model.LeagueData
import uz.gita.futboollegueapplication.data.model.ResponseData

interface LeagueApi {

    @GET("arkhiv-kursov-valyut/json/")
    fun getAllData(): Call<ResponseData<List<LeagueData>>>
//    @GET("/leagues/{id}/standings")
//    fun getAllDataByData(
//        @Path("id") id: String,
//        @Query("season") year: Int
//    )
//    : Call<ResponseData<SeasonData>>

}