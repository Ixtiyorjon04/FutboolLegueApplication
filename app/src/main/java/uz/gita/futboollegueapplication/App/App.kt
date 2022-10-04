package uz.gita.futboollegueapplication.App

import android.app.Application
import uz.gita.futboollegueapplication.room.database.LeagueDataBase

class App : Application() {
    companion object{
        lateinit var instance : App
    }

    override fun onCreate() {
        super.onCreate()

        LeagueDataBase.init(this)

        instance = this

    }
}