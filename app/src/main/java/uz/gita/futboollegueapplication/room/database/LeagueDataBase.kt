package uz.gita.futboollegueapplication.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import uz.gita.futboollegueapplication.data.model.Converters
import uz.gita.futboollegueapplication.data.model.LeagueData
import uz.gita.futboollegueapplication.data.model.SeasonData
import uz.gita.futboollegueapplication.data.model.Standing
import uz.gita.futboollegueapplication.room.dao.LeagueDao

@Database(entities = [LeagueData::class,SeasonData::class], version = 1)
@TypeConverters(Converters::class)
abstract class LeagueDataBase : RoomDatabase() {

    abstract fun getLeagueDao(): LeagueDao

    companion object {
        private var db: LeagueDataBase? = null

        fun init(context: Context) {
            db = Room.databaseBuilder(
                context.applicationContext,
                LeagueDataBase::class.java,
                "kleague_db.db"
            )
                .allowMainThreadQueries().build()

        }

        fun getInstance() = db!!
    }

}