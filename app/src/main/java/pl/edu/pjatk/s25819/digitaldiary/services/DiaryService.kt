package pl.edu.pjatk.s25819.digitaldiary.services

import android.util.Log
import pl.edu.pjatk.s25819.digitaldiary.http.RetrofitClient
import pl.edu.pjatk.s25819.digitaldiary.model.DiaryRecord

class DiaryService {

    suspend fun getAll(): List<DiaryRecord> {

        val response = RetrofitClient.api.getAllRecords()
        Log.i(TAG, "getAll: $response")
        return response
    }

    companion object {
        private const val TAG = "DiaryService"
    }
}