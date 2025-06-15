package pl.edu.pjatk.s25819.digitaldiary.model

import kotlinx.serialization.Serializable

@Serializable
data class DiaryRecord(
    val id: Int,
    val title: String,
    val content: String,
    val location: String
) {
}