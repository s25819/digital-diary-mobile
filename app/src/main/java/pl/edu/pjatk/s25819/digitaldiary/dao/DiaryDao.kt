package pl.edu.pjatk.s25819.digitaldiary.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import pl.edu.pjatk.s25819.digitaldiary.model.DiaryRecord

@Dao
interface DiaryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createOrUpdate(diaryRecord: DiaryRecord)
}