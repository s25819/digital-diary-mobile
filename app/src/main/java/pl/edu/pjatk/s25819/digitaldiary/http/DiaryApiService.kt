package pl.edu.pjatk.s25819.digitaldiary.http

import pl.edu.pjatk.s25819.digitaldiary.model.DiaryRecord
import retrofit2.http.GET

interface DiaryApiService {

    @GET("diary")
    suspend fun getAllRecords() : List<DiaryRecord>
}