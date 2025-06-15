package pl.edu.pjatk.s25819.digitaldiary.http

import pl.edu.pjatk.s25819.digitaldiary.model.DiaryRecord
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface DiaryApiService {

    @GET("diary")
    suspend fun getAllRecords() : List<DiaryRecord>

    @POST("diary")
    suspend fun createRecord(@Body diaryRecord: DiaryRecord) : Int
}