package pl.edu.pjatk.s25819.digitaldiary.fragments

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pl.edu.pjatk.s25819.digitaldiary.R
import pl.edu.pjatk.s25819.digitaldiary.model.DiaryRecord
import pl.edu.pjatk.s25819.digitaldiary.navigation.Destination
import pl.edu.pjatk.s25819.digitaldiary.navigation.EditDiaryRecord
import pl.edu.pjatk.s25819.digitaldiary.services.DiaryService
import pl.edu.pjatk.s25819.przeterminarz.navigation.CreateNewDiaryRecord

class DiaryRecordsListViewModel : ViewModel() {
    private val diaryService = DiaryService()

    private val _diaryRecords = MutableLiveData<List<DiaryRecord>>()
    val diaryRecords: LiveData<List<DiaryRecord>> = _diaryRecords
    val navigation = MutableLiveData<Destination>()

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

    fun refreshRecords() {
        loadDiaryRecords()
    }

    fun navigateToCreate() {
        navigation.value = CreateNewDiaryRecord()
    }

    fun navigateToEdit(diaryRecord: DiaryRecord) {
        navigation.value = EditDiaryRecord(diaryRecord)
    }

    fun onDestinationChanged(controller: NavController, destination: NavDestination, arguments: Bundle?) {
        if (destination.id == R.id.diaryListFragment) {
            refreshRecords()
        }
    }
}