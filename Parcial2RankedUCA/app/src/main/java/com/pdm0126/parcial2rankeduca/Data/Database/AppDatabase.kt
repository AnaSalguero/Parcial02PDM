package com.pdm0126.parcial2rankeduca.Data.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pdm0126.parcial2rankeduca.Data.Database.Dao.OptionDao
import com.pdm0126.parcial2rankeduca.Data.Database.Dao.QuestionDao
import com.pdm0126.parcial2rankeduca.Data.Database.Entities.OptionEntity
import com.pdm0126.parcial2rankeduca.Data.Database.Entities.QuestionEntity

@Database(
    entities = [QuestionEntity::class, OptionEntity::class],
    version = 3,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun optionDao(): OptionDao
    abstract fun questionDao(): QuestionDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                 Room.databaseBuilder(
                    context = context.applicationContext,
                    klass = AppDatabase::class.java,
                    name = "rankeuca_database"
                )
                    .fallbackToDestructiveMigration(false)
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}