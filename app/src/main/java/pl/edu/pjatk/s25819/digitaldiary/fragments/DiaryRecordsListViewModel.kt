package pl.edu.pjatk.s25819.digitaldiary.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pl.edu.pjatk.s25819.digitaldiary.model.DiaryRecord
import pl.edu.pjatk.s25819.digitaldiary.services.DiaryService

class DiaryRecordsListViewModel : ViewModel() {
    private val diaryService = DiaryService()

    private val _diaryRecords = MutableLiveData<List<DiaryRecord>>()
    val diaryRecords: LiveData<List<DiaryRecord>> = _diaryRecords

    init {
        loadDiaryRecords()
    }

    fun loadDiaryRecords() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val list = diaryService.getAll()
                _diaryRecords.postValue(list)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}