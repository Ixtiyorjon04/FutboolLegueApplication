package uz.gita.futboollegueapplication.retrofit

import com.chuckerteam.chucker.api.ChuckerInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.gita.futboollegueapplication.App.App

object ApiClient {
    val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .addInterceptor(ChuckerInterceptor.Builder(App.instance).build())
        .build()

    val retrofit = Retrofit.Builder().baseUrl("http://cbu.uz/uzc/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

}