package pl.edu.pjatk.s25819.digitaldiary.http

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

object RetrofitClient {

//    private const val BASE_SERVER_URL = "http://localhost:8080/"
    private const val BASE_SERVER_URL = "http://10.0.2.2:8080/"

    val api: DiaryApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_SERVER_URL)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
            .create(DiaryApiService::class.java)
    }
}