package pl.edu.pjatk.s25819.digitaldiary.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity
data class DiaryRecord(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val memo: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val location: String,
    val image: String
) {
}