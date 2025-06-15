package pl.edu.pjatk.s25819.digitaldiary.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pl.edu.pjatk.s25819.digitaldiary.dao.DiaryDao
import pl.edu.pjatk.s25819.digitaldiary.model.DiaryRecord

@Database(entities = [DiaryRecord::class], version = 1)
abstract class DiaryDB : RoomDatabase() {

    abstract fun diaryDao(): DiaryDao

    companion object {
        const val DATABASE_NAME = "digital_diary_db"
        private var instance: DiaryDB? = null

        fun getInstance(context: Context): DiaryDB {
            return instance ?: createNewDatabase(context)
        }

        private fun createNewDatabase(context: Context): DiaryDB {
            instance = Room.databaseBuilder(
                        context.applicationContext,
                        DiaryDB::class.java,
                        DATABASE_NAME
                    ).fallbackToDestructiveMigration(false).build()

            return instance!!
        }
    }
}